package com.rongzi.core.base.tips;

import java.io.Serializable;

/**
 * 返回给前台的成功提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public SuccessTip(){
		super.code = 200;
		super.message = "操作成功";
	}
}
