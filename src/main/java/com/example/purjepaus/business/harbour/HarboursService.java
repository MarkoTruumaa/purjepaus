package com.example.purjepaus.business.harbour;

import com.example.purjepaus.business.harbour.dto.HarbourDetailedInfo;
import com.example.purjepaus.business.harbour.dto.HarbourMainInfo;
import com.example.purjepaus.business.harbour.extra.ExtraInfo;
import com.example.purjepaus.business.harbour.picture.PictureDto;
import com.example.purjepaus.business.user.ContactInfo;
import com.example.purjepaus.domain.Contact;
import com.example.purjepaus.domain.ContactMapper;
import com.example.purjepaus.domain.ContactService;
import com.example.purjepaus.domain.harbour.harbourextra.HarbourExtraService;
import com.example.purjepaus.domain.harbour.extra.Extra;
import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.harbour.HarbourMapper;
import com.example.purjepaus.domain.harbour.HarbourService;
import com.example.purjepaus.domain.harbour.extra.ExtraMapper;
import com.example.purjepaus.domain.harbour.harborpicture.HarbourPictureService;
import com.example.purjepaus.domain.harbour.picture.Picture;
import com.example.purjepaus.domain.harbour.picture.PictureMapper;
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
}
