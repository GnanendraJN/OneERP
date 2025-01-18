package org.oneerp.about;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactDetails {

    public String contactName;
    private String email;
    private String city;
    private String mobile;
}
