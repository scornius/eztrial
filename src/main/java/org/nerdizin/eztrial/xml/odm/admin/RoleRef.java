package org.nerdizin.eztrial.xml.odm.admin;

import javax.xml.bind.annotation.XmlAttribute;

public class RoleRef {

	@XmlAttribute(name = "RoleOID")
	private String roleOid;

	public String getRoleOid() {
		return roleOid;
	}

	public void setRoleOid(final String roleOid) {
		this.roleOid = roleOid;
	}
}
