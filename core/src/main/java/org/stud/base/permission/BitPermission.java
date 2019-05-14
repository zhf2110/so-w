package org.stud.base.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.util.StringUtils;

/**
 * 自定与权限对象解析器
 *
 * +资源字符串+权限位+实例ID；以+开头中间通过+分割；
 * 权限：0 表示所有权限；1 新增（二进制：0001）、2 修改（二进制：0010）、4 删除（二进制：0100）、8 查看（二进制：1000）；
 * 如 +user+10 表示对资源user拥有修改/查看权限
 *
 * @author zhangfeng542
 * @date 5/6/19
 */
public class BitPermission implements Permission{

	private String sourceID;

	private int permis;

	private String instanceID;

	public BitPermission(String perString){
		String[] str = perString.split("\\+");
		if(str.length > 1){
			sourceID = str[1];
		}
		if(!StringUtils.hasText(sourceID)){
			sourceID = "*";
		}
		if(str.length > 2){
			permis = Integer.valueOf(str[2]);
		}
		if(str.length > 3){
			instanceID = str[3];
		}
		if(!StringUtils.hasText(instanceID)){
			instanceID = "*";
		}
	}

	/**
	 * 判断是否拥有权限，返回true说明存在此权限
	 * @param permission
	 * @return
	 */
	@Override
	public boolean implies(Permission permission) {
		if(permission instanceof BitPermission){
			BitPermission other = (BitPermission)permission;
			return this.equals(other);
		}else{
			return false;
		}
	}

	@Override
	public boolean equals(Object obj) {
		BitPermission other = (BitPermission)obj;
		if(!("*".equals(this.sourceID) || this.sourceID.equals(other.sourceID))) {
			return false;
		}
		if(!(this.permis ==0 || (this.permis & other.permis) != 0)) {
			return false;
		}
		if(!("*".equals(this.instanceID) || this.instanceID.equals(other.instanceID))) {
			return false;
		}
		return true;
	}
}
