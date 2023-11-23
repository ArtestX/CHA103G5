package com.cha103g5.adoptedapplicationhibernate.service;

import com.cha103g5.admin.model.AdminVO;
import com.cha103g5.admin.service.AdminService;
import com.cha103g5.adoptedapplicationhibernate.dao.AdoptedApplicationHibernateDao;
import com.cha103g5.adoptedapplicationhibernate.dao.AdoptedApplicationHibernateDaoImpl;
import com.cha103g5.adoptedapplicationhibernate.model.AdoptedApplicationHibernate;
import com.cha103g5.member.model.MemberService;
import com.cha103g5.member.model.MemberVO;
import com.cha103g5.pet.model.PetVO;
import com.cha103g5.pet.service.PetService;

import java.sql.Date;
import java.time.LocalTime;
import java.util.*;


import static com.cha103g5.adoptedapplicationhibernate.util.Constants.PAGE_MAX_RESULT;

public class AdoptedApplicationHibernateServiceImpl implements AdoptedApplicationHibernateService {

    AdoptedApplicationHibernateDao dao = new AdoptedApplicationHibernateDaoImpl();

    @Override
    public int addApplication(AdoptedApplicationHibernate application) {
        return dao.add(application);
    }

    @Override
    public int updateApplication(AdoptedApplicationHibernate application) {
        return dao.update(application);
    }

    @Override
    public int deleteApplication(Integer applicationNo) {
        return dao.delete(applicationNo);
    }

    @Override
    public AdoptedApplicationHibernate getApplicationById(Integer applicationNo) {
        AdoptedApplicationHibernate application = dao.getById(applicationNo);
        convertSignaturePhotoToBase64(application);
        return application;
    }

    @Override
    public List<AdoptedApplicationHibernate> getAllApplications() {
        List<AdoptedApplicationHibernate> applications = dao.getAll();
        applications.forEach(this::convertSignaturePhotoToBase64);
        return applications;
    }

    @Override
    public List<AdoptedApplicationHibernate> getApplicationsByPetIdAndLotteryDate(Integer petId) {
        List<AdoptedApplicationHibernate> applications = dao.getByPetIdAndLotteryDate(petId);
        applications.forEach(this::convertSignaturePhotoToBase64);
        return applications;
    }

    @Override
    public List<AdoptedApplicationHibernate> getApplicationsByDatedAndTime(Date interactionDate, LocalTime startTime, LocalTime endTime) {
        List<AdoptedApplicationHibernate> applications = dao.getByDatedAndTime(interactionDate, startTime, endTime);
        applications.forEach(this::convertSignaturePhotoToBase64);
        return applications;
    }

    @Override
    public List<AdoptedApplicationHibernate> getApplicationsByMemberNo(Integer memberNo) {
        List<AdoptedApplicationHibernate> applications = dao.getByMemberNo(memberNo);
        applications.forEach(this::convertSignaturePhotoToBase64);
        return applications;
    }

    @Override
    public List<AdoptedApplicationHibernate> getApplicationsByCompositeQuery(Map<String, String[]> map) {

        Map<String, String> query = new HashMap<>();
        Set<Map.Entry<String, String[]>> entry = map.entrySet();

        for (Map.Entry<String, String[]> row : entry) {
            String key = row.getKey();
            if ("action".equals(key)) {
                continue;
            }

            String value = row.getValue()[0];
            if (value == null || value.isEmpty()) {
                continue;
            }
            query.put(key, value);
        }
        System.out.println("query: " + query);

        List<AdoptedApplicationHibernate> applications = dao.getByCompositeQuery(query);
        applications.forEach(this::convertSignaturePhotoToBase64);
        return applications;
    }

    @Override
    public List<AdoptedApplicationHibernate> getAllApplications(int currentPage) {
        List<AdoptedApplicationHibernate> applications = dao.getAll(currentPage);
        applications.forEach(this::convertSignaturePhotoToBase64);
        return applications;
    }

    @Override
    public int getPageTotal() {
        long total = dao.getTotal();
        int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
        return pageQty;
    }

    @Override
    public int getDataTotal() {
        return (int)(dao.getTotal());
    }

    private void convertSignaturePhotoToBase64(AdoptedApplicationHibernate application) {
        if (application.getSignaturePhoto() != null) {
            String photoBase64 = Base64.getEncoder().encodeToString(application.getSignaturePhoto());
            application.setSignaturePhotoBase64(photoBase64);
        }
    }

    AdminService adminService = new AdminService();
    MemberService memberService = new MemberService();
    PetService petService = new PetService();

    @Override
    public AdminVO getRandomAdmin() {
        List<AdminVO> allAdmins = adminService.getAll();
        Random random = new Random();
        return allAdmins.get(random.nextInt(allAdmins.size()));
    }

    @Override
    public MemberVO getRandomMember() {
        List<MemberVO> allMembers = memberService.getAllMembers();
        Random random = new Random();
        return allMembers.get(random.nextInt(allMembers.size()));
    }

    @Override
    public PetVO getRandomPet() {
        List<PetVO> allPets = petService.getAll();
        Random random = new Random();
        return allPets.get(random.nextInt(allPets.size()));
    }

}
