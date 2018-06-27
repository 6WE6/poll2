package com.briup.apps.poll.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * POJO类    学校
 * @author yun
 */
@ApiModel(value="学校")
public class School {
	
	@ApiModelProperty(value="主键自增策略")
    private Long id;

	@ApiModelProperty(value="学校的名字")
    private String name;

	@ApiModelProperty(value="图标路径")
    private String logopath;

	@ApiModelProperty(value="学校地址")
    private String address;

	@ApiModelProperty(value="联系方式")
    private String telephone;

	@ApiModelProperty(value="版权")
    private String copyright;

	@ApiModelProperty(value="关于学校的描述")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath == null ? null : logopath.trim();
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}