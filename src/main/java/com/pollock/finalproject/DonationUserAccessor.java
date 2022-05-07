package com.pollock.finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DonationUserAccessor {
    private List<DonationUser> users = new ArrayList<DonationUser>();

    public DonationUserAccessor(){
        HashMap<String, Boolean> AdminPermissions = new HashMap<>();
        AdminPermissions.put("admin", true);
        AdminPermissions.put("active", true);
        HashMap<String, Boolean> NormalPermissions = new HashMap<>();
        NormalPermissions.put("admin", false);
        NormalPermissions.put("active", true);

        HashMap<String, Boolean> DeactivatedPermissions = new HashMap<>();
        NormalPermissions.put("admin", false);
        NormalPermissions.put("active", false);

        users.add(new DonationUser("Tess", "Data", "tess@real.com", "P@ssw0rd", NormalPermissions, "1970-11-04"));
        users.add(new DonationUser("Admin", "McGuffin", "adming@real.com", "P@ssw0rdle", AdminPermissions, "1996-01-23"));
        users.add(new DonationUser("Emilia", "Codder", "emcod@real.com", "P@ssw0rdle", NormalPermissions, "2002-06-10"));
        users.add(new DonationUser("Noah", "Westwater", "noahman108@real.com", "P@ssw0rd", NormalPermissions, "2001-09-09"));
        users.add(new DonationUser("Greg", "Smith", "gregert@real.com", "P@ssw0rd", NormalPermissions, "1984-04-05"));
        users.add(new DonationUser("Richard", "Carlson", "rcarlson@real.com", "P@ssw0rd", DeactivatedPermissions, "1992-12-14"));
    }

    public List<DonationUser> getUsers(){
        return users;
    }
    public DonationUser getUserByEmail(String email){
        DonationUser result = null;
        for(DonationUser user : users){
            if(user.getEmail().equals(email)){
                result = user;
            }
        }
        return result;
    }
    public boolean authenticateUser(String email, String password){
        DonationUser user = getUserByEmail(email);
        if(user == null){
            return false;
        }
        return user.authenticatePassword(password);
    }
}
