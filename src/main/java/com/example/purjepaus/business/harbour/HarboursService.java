package com.example.purjepaus.business.harbour;

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
import org.springframework.stereotype.Service;

import java.util.List;

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
}
