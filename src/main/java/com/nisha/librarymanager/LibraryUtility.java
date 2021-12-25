package com.nisha.librarymanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;
import java.util.Date;

// Helper class
@Component
public class LibraryUtility {

    @Autowired
    StringUtils stringUtils;

    public boolean isBeyondToday(Date inputDate) {
        String input = "vicky";
        return false;
    }
}
