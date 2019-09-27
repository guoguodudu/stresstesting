package com.stress.test.shiro;

import com.stress.test.domain.user.Permission;
import com.stress.test.domain.user.Role;
import com.stress.test.domain.user.User;
import com.stress.test.mapper.user.PermissionMapper;
import com.stress.test.mapper.user.RoleMapper;
import com.stress.test.service.user.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionMapper permissionMapper;

	/**
	 * 获取用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 获取用户角色集
		List<Role> roleList = roleMapper.findByUserRole(user.getId());
		Set<String> roleSet = new HashSet<String>();
		for (Role r : roleList) {
			roleSet.add(r.getCode());
		}
		simpleAuthorizationInfo.setRoles(roleSet);

		// 获取用户权限集
		List<Permission> permissionList = permissionMapper.findByUserPermission(user.getId());
		Set<String> permissionSet = new HashSet<String>();
		for (Permission p : permissionList) {
			permissionSet.add(p.getCode());
		}
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());

		User user = userMapper.getUserByLogin(userName);

		if (user == null) {
			throw new UnknownAccountException("用户名不存在！");
		}
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("用户名或密码错误！");
		}
		if (user.getState().equals("0")) {
			throw new LockedAccountException("账号已被锁定,请联系管理员！");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
