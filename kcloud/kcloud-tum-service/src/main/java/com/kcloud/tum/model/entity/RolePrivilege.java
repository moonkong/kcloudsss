package com.kcloud.tum.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色和权限的关联表
 * </p>
 *
 * @author Walle
 * @since 2019-01-23
 */
@TableName("t_role_privilege")
public class RolePrivilege implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 角色id
     */
    private Long roleid;
    /**
     * 权限id
     */
    private Long privilegeid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getPrivilegeid() {
        return privilegeid;
    }

    public void setPrivilegeid(Long privilegeid) {
        this.privilegeid = privilegeid;
    }

    @Override
    public String toString() {
        return "RolePrivilege{" +
        ", id=" + id +
        ", roleid=" + roleid +
        ", privilegeid=" + privilegeid +
        "}";
    }
}
