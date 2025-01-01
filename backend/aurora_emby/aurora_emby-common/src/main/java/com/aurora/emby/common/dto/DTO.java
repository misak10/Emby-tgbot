package com.aurora.emby.common.dto;

import java.io.Serializable;

/**
 * @className DTO
 * @description: Data Transfer object, including Command, Query and Response, Command and Query is CQRS concept.
 */
public abstract class DTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public DTO() {
    }

}
