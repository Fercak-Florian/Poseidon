package com.nnk.springboot.utils;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
	
	private OAuth2AuthorizedClientService authorizedClientService;
	
	public CurrentUser(OAuth2AuthorizedClientService authorizedClientService) {
		this.authorizedClientService = authorizedClientService;
	}
	
	/*AJOUT DE MA METHODE*/
	/*public Principal getCurrentPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}*/
	
	public String getUserInfo(Principal user) {
		/*--------------------------------------------*/
		
		/*--------------------------------------------*/
		StringBuffer userInfo = new StringBuffer();
		
		if(user instanceof UsernamePasswordAuthenticationToken) {
			/*AUTHENTIFICATION CLASSIQUE*/
			userInfo.append(getUsernamePasswordLoginInfo(user));
			//System.out.println(userInfo.toString());
		} else if(user instanceof OAuth2AuthenticationToken) {
			/*AUTHENTIFICATION AVEC OAUTH*/
			userInfo.append(getOauth2LoginInfo(user));
		}
		//System.out.println(userInfo.toString());
		return userInfo.toString();
	}
	
	/*RECUPERE LES INFORMATIONS DE CONNEXION AVEC OAUTH*/
	private StringBuffer getOauth2LoginInfo(Principal user) {
		StringBuffer protectedInfo = new StringBuffer();
		OAuth2AuthenticationToken authToken = ((OAuth2AuthenticationToken) user);
		OAuth2AuthorizedClient authClient = this.authorizedClientService.loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(), authToken.getName());
		Map<String, Object> userDetails = ((DefaultOAuth2User) authToken.getPrincipal()).getAttributes();
		String userToken = authClient.getAccessToken().getTokenValue();
		protectedInfo.append("User name " + userDetails.get("name"));
		protectedInfo.append("Email : " + userDetails.get("email"));
		protectedInfo.append("Access Token : " + userToken);
		return protectedInfo;
	}
	
	/*RECUPERE LES INFORMATIONS DE CONNEXION CLASSIQUE*/
	private StringBuffer getUsernamePasswordLoginInfo(Principal user) {
		StringBuffer usernameInfo = new StringBuffer();
		UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
		if(token.isAuthenticated()) {
			User u = (User) token.getPrincipal();
			usernameInfo.append("Welcome, " + u.getUsername());
		} else {
			usernameInfo.append("NA");
		}
		return usernameInfo;
	}
}
