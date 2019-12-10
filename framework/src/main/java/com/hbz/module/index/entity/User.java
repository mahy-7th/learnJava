package com.hbz.module.index.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author mahy
 * @Time 2019-12-05 15:57
 * @Describe : Here is the description
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -2543121548344189296L;

	private Integer id;

	private String name;
}
