package com.example.purjepaus.business.harbour;

import com.example.purjepaus.business.harbour.dto.UpdateHarbourAndExtras;
import com.example.purjepaus.business.user.dto.ContactInfo;
import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import com.example.purjepaus.business.harbour.dto.HarbourMainInfo;
import com.example.purjepaus.business.harbour.extra.ExtraInfo;
import com.example.purjepaus.business.harbour.picture.PictureDto;
import com.example.purjepaus.domain.harbour.extra.ExtraService;
import com.example.purjepaus.domain.harbour.harborpicture.HarbourPicture;
import com.example.purjepaus.domain.harbour.harbourextra.HarbourExtra;
import com.example.purjepaus.domain.harbour.location.Location;
import com.example.purjepaus.domain.harbour.location.LocationMapper;
import com.example.purjepaus.domain.harbour.location.LocationService;
import com.example.purjepaus.domain.harbour.location.county.County;
import com.example.purjepaus.domain.harbour.location.county.CountyService;
import com.example.purjepaus.domain.harbour.picture.PictureService;
import com.example.purjepaus.domain.user.contact.Contact;
import com.example.purjepaus.domain.user.contact.ContactMapper;
import com.example.purjepaus.domain.user.contact.ContactService;
import com.example.purjepaus.domain.harbour.harbourextra.HarbourExtraService;
import com.example.purjepaus.domain.harbour.extra.Extra;
import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.harbour.HarbourMapper;
import com.example.purjepaus.domain.harbour.HarbourService;
import com.example.purjepaus.domain.harbour.extra.ExtraMapper;
import com.example.purjepaus.domain.harbour.harborpicture.HarbourPictureService;
import com.example.purjepaus.domain.harbour.picture.Picture;
import com.example.purjepaus.domain.harbour.picture.PictureMapper;
import com.example.purjepaus.util.PictureConverter;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.purjepaus.business.Status.*;

@Service
public class HarboursService {

    @Resource
    private HarbourService harbourService;
    @Resource
    private HarbourMapper harbourMapper;
    @Resource
    private ExtraMapper extraMapper;
    @Resource
    private HarbourExtraService harbourExtraService;
    @Resource
    private HarbourPictureService harbourPictureService;
    @Resource
    private ContactService contactService;
    @Resource
    private ContactMapper contactMapper;
    @Resource
    private PictureMapper pictureMapper;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private CountyService countyService;
    @Resource
    private LocationService locationService;
    @Resource
    private ExtraService extraService;
    @Resource
    private PictureService pictureService;


    public List<HarbourMainInfo> getHarboursInfo() {
        List<Harbour> harbours = harbourService.getActiveHarboursInfo();
        return harbourMapper.toHarboursMainInfo(harbours);
    }

    public HarbourDetailedInfo getHarbourInfo(Integer harbourId) {
        Harbour harbour = harbourService.getHarbourInfoBy(harbourId);
        HarbourDetailedInfo harbourDetailedInfoDto = harbourMapper.toHarbourDetailedInfo(harbour);
        findAndSetExtrasToHarbourInfo(harbourId, harbourDetailedInfoDto);
        findAndSetPicturesToHarbourInfo(harbourId, harbourDetailedInfoDto);

        return harbourDetailedInfoDto;
    }

    private void findAndSetExtrasToHarbourInfo(Integer harbourId, HarbourDetailedInfo harbourDetailedInfoDto) {
        List<Extra> extras = harbourExtraService.findExtrasBy(harbourId);
        List<ExtraInfo> extraInfos = extraMapper.toExtraInfos(extras);
        harbourDetailedInfoDto.setExtras(extraInfos);
    }

    private void findAndSetPicturesToHarbourInfo(Integer harbourId, HarbourDetailedInfo harbourDetailedInfoDto) {
        List<Picture> pictures = harbourPictureService.findPicturesBy(harbourId);
        List<PictureDto> pictureDtos = pictureMapper.toPictureDtos(pictures);
        harbourDetailedInfoDto.setPictures(pictureDtos);
    }

    public ContactInfo getCaptainContactInfo(Integer contactId) {
        Contact contact = contactService.getContactInfoBy(contactId);
        return contactMapper.toContactInfo(contact);
    }

    @Transactional
    public void addNewHarbour(HarbourDetailedInfo harbourDetailedInfo) {
        checkHarbourNameAvailability(harbourDetailedInfo);
        Location location = createAndSaveLocation(harbourDetailedInfo);
        Harbour harbour = createAndSaveHarbour(harbourDetailedInfo, location);
        createAndSaveHarbourExtras(harbourDetailedInfo, harbour);
        createAndSaveHarbourPicture(harbourDetailedInfo, harbour);


    }

    private void checkHarbourNameAvailability(HarbourDetailedInfo harbourDetailedInfo) {
        String harbourName = harbourDetailedInfo.getHarbourName();
        harbourService.confirmHarbourNameAvailability(harbourName);
    }

    private Location createAndSaveLocation(HarbourDetailedInfo harbourDetailedInfo) {
        County county = countyService.getCountyBy(harbourDetailedInfo.getCountyName());

        Location location = locationMapper.toLocation(harbourDetailedInfo);
        location.setCounty(county);
        locationService.saveLocation(location);
        return location;
    }

    private Harbour createAndSaveHarbour(HarbourDetailedInfo harbourDetailedInfo, Location location) {
        Contact contact = contactService.getContactInfoBy(harbourDetailedInfo.getContactId());

        Harbour harbour = harbourMapper.toHarbour(harbourDetailedInfo);
        harbour.setLocation(location);
        harbour.setContact(contact);
        harbourService.saveHarbour(harbour);
        return harbour;
    }

    private void createAndSaveHarbourExtras(HarbourDetailedInfo harbourDetailedInfo, Harbour harbour) {
        HarbourExtra harbourExtra = new HarbourExtra();

        for (ExtraInfo extraInfo : harbourDetailedInfo.getExtras()) {
            if (extraInfo.getIsAvailable()) {
                Integer extraId = extraInfo.getExtraId();
                Extra extra = extraService.getExtraBy(extraId);
                harbourExtra.setHarbour(harbour);
                harbourExtra.setExtra(extra);
                harbourExtra.setIsAvailable(extraInfo.getIsAvailable());
                harbourExtraService.saveHarbourExtra(harbourExtra);
            }

        }
    }

    private void createAndSaveHarbourPicture(HarbourDetailedInfo harbourDetailedInfo, Harbour harbour) {
        HarbourPicture harbourPicture = new HarbourPicture();

        for (PictureDto pictureDto : harbourDetailedInfo.getPictures()) {
            Picture picture = PictureConverter.pictureDataToPicture(pictureDto.getPictureData());
            pictureService.savePicture(picture);
            harbourPicture.setHarbor(harbour);
            harbourPicture.setPicture(picture);
            harbourPictureService.saveHarbourPicture(harbourPicture);
        }
    }

    public List<ExtraInfo> getHarbourExtras() {
        List<Extra> extras = extraService.getExtras();
        return extraMapper.toExtraInfos(extras);
    }

    @Transactional
    public void updateHarbourInfo(Integer harbourId, UpdateHarbourAndExtras updatedInfo) {
        Harbour harbour = harbourService.getHarbourInfoBy(harbourId);
        Integer requestContactId = updatedInfo.getContactId();
        handleContactUpdate(requestContactId, harbour);
        handleLocationUpdate(updatedInfo, harbour);
        handleHarbourUpdate(updatedInfo, harbour);
        handleHarbourExtrasUpdate(harbourId, updatedInfo);
    }

    private void handleContactUpdate(Integer requestContactId, Harbour harbour) {
        if (!haveSameContactId(harbour, requestContactId)) {
            Contact contact = contactService.getContactInfoBy(requestContactId);
            harbour.setContact(contact);
        }
    }

    private static boolean haveSameContactId(Harbour harbour, Integer requestContactId) {
        return harbour.getContact().getId().equals(requestContactId);
    }

    private void handleLocationUpdate(UpdateHarbourAndExtras updatedInfo, Harbour harbour) {
        Location location = harbour.getLocation();
        Integer requestCountyId = updatedInfo.getLocationCountyId();
        updateCounty(location, requestCountyId);
        locationMapper.partialUpdate(updatedInfo, location);
        locationService.saveLocation(location);
    }

    private void updateCounty(Location location, Integer requestCountyId) {
        if (!haveSameCountyId(location, requestCountyId)) {
            County county = countyService.getCountyBy(requestCountyId);
            location.setCounty(county);
        }
    }

    private static boolean haveSameCountyId(Location location, Integer requestCountyId) {
        return location.getCounty().getId().equals(requestCountyId);
    }

    private void handleHarbourUpdate(UpdateHarbourAndExtras updatedInfo, Harbour harbour) {
        harbourMapper.partialUpdate(updatedInfo, harbour);
        harbourService.saveHarbour(harbour);
    }

    private void handleHarbourExtrasUpdate(Integer harbourId, UpdateHarbourAndExtras updatedInfo) {
        for (ExtraInfo updatedInfoExtra : updatedInfo.getExtras()) {
            HarbourExtra harbourExtra = harbourExtraService.findHarbourExtraBy(harbourId, updatedInfoExtra.getExtraId());
            if (isAvailableValuesAreDifferent(updatedInfoExtra, harbourExtra)) {
                harbourExtra.setIsAvailable(updatedInfoExtra.getIsAvailable());
                harbourExtraService.saveHarbourExtra(harbourExtra);
            }
        }
    }

    private static boolean isAvailableValuesAreDifferent(ExtraInfo updatedInfoExtra, HarbourExtra harbourExtra) {
        return !updatedInfoExtra.getIsAvailable().equals(harbourExtra.getIsAvailable());
    }

    public void deleteHarbour(Integer harbourId) {
        Harbour harbour = harbourService.getHarbourInfoBy(harbourId);
        harbour.setStatus(DELETED.getLetter());

    }
}
