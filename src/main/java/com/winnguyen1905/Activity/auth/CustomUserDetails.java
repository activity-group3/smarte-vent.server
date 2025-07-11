package com.winnguyen1905.activity.auth;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.winnguyen1905.activity.common.constant.AccountRole;

import lombok.Builder;

@Builder
public record CustomUserDetails(
    Long id,
    String type,
    String email,
    String phone,
    AccountRole role,
    Boolean status,
    String lastName,
    String username,
    String password,
    String firstName) implements UserDetails {
  @Builder
  public CustomUserDetails(
      Long id,
      String type,
      String email,
      String phone,
      AccountRole role,
      Boolean status,
      String lastName,
      String username,
      String password,
      String firstName) {
    this.id = id;
    this.type = type;
    this.email = email;
    this.phone = phone;
    this.role = role;
    this.status = status;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role));
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
