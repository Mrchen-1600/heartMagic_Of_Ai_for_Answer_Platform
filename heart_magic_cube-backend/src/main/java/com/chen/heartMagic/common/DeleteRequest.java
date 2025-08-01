package com.chen.heartMagic.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 删除请求
 *
 * @author 尘小风
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}