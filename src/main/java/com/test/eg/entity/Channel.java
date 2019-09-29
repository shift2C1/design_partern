package com.test.eg.entity;

import lombok.Data;

import java.util.Set;

@Data
public class Channel {
    String name;
    Set<IMClient> subscriptionSet;
}
