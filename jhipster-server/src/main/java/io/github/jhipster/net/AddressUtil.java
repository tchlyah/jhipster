/*
 * Copyright 2016-2018 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see http://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.jhipster.net;

import de.malkusch.whoisServerList.publicSuffixList.PublicSuffixList;
import de.malkusch.whoisServerList.publicSuffixList.PublicSuffixListFactory;

import java.util.regex.Pattern;

public interface AddressUtil {

    static final Pattern IPv4 = Pattern.compile(
        "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])"
    );

    static final Pattern IPv6 = Pattern.compile(
        "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}"
    );

    static final PublicSuffixList SUFFICES = new PublicSuffixListFactory().build();

    public static boolean isIPv4(String address) {
        return IPv4.matcher(address).matches();
    }

    public static boolean isIPv6(String address) {
        return IPv6.matcher(address).matches();
    }

    public static boolean isIP(String address) {
        return AddressUtil.isIPv4(address) || AddressUtil.isIPv6(address);
    }

    public static String getRegistrableDomain(String address) {
        return SUFFICES.getRegistrableDomain(address);
    }
}
