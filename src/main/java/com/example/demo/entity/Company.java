package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author links
 * @since 2018-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_company")
public class Company extends Model<Company> {

    private static final long serialVersionUID = 1L;

    /**
     * 企业id，主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名称，唯一
     */
    private String name;

    /**
     * 企业地址
     */
    private String address;

    private LocalDateTime createTime;

    private Boolean isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
