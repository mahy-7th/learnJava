package com.hbz.module.index.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author mahy
 * @Time 2019-12-05 15:59
 * @Describe : Here is the description
 */
@Data
public class Users implements Serializable {

	private static final long serialVersionUID = 653585964252503850L;

	private Integer id;

	private String address;


}
