package com.farukgenc.boilerplate.springboot.model.ids;

import java.io.Serial;
import java.io.Serializable;

public class OrganizationId implements Serializable {
    @Serial
    private static final long serialVersionUID = -4209093678470383087L;

    private String id;
    private String contactPersonId;
}
