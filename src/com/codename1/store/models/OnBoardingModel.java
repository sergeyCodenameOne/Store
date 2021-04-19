/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Codename One through http://www.codenameone.com/ if you
 * need additional information or have any questions.
 */

package com.codename1.store.models;

import com.codename1.rad.models.Entity;
import com.codename1.rad.models.EntityType;
import com.codename1.rad.models.StringProperty;
import com.codename1.store.interfaces.OnBoarding;




public class OnBoardingModel extends Entity {
    public static StringProperty logo;
    public static StringProperty firstSlideImage;
    public static StringProperty secondSlideImage;
    public static StringProperty thirdSlideImage;
    public static StringProperty firstSlideTitle;
    public static StringProperty secondSlideTitle;
    public static StringProperty thirdSlideTitle;
    public static StringProperty firstSlideText;
    public static StringProperty secondSlideText;
    public static StringProperty thirdSlideText;


    public static final EntityType TYPE = new EntityType(){{
        logo = string(tags(OnBoarding.logo));
        firstSlideImage = string(tags(OnBoarding.onBoardingFirstSlideImage));
        secondSlideImage = string(tags(OnBoarding.onBoardingSecondSlideImage));
        thirdSlideImage = string(tags(OnBoarding.onBoardingThirdSlideImage));
        firstSlideTitle = string(tags(OnBoarding.onBoardingFirstSlideTitle));
        secondSlideTitle = string(tags(OnBoarding.onBoardingSecondSlideTitle));
        thirdSlideTitle = string(tags(OnBoarding.onBoardingThirdSlideTitle));
        firstSlideText = string(tags(OnBoarding.onBoardingFirstSlideText));
        secondSlideText = string(tags(OnBoarding.onBoardingSecondSlideText));
        thirdSlideText = string(tags(OnBoarding.onBoardingThirdSlideText));

    }};

    {
        setEntityType(TYPE);
    }

    public OnBoardingModel(String logo, String firstSlideImage, String secondSlideImage,
                           String thirdSlideImage, String firstSlideTitle, String secondSlideTitle, String thirdSlideTitle,
                           String firstSlideText, String secondSlideText, String thirdSlideText){

        set(this.logo, logo);
        set(this.firstSlideImage, firstSlideImage);
        set(this.secondSlideImage, secondSlideImage);
        set(this.thirdSlideImage, thirdSlideImage);
        set(this.firstSlideTitle, firstSlideTitle);
        set(this.secondSlideTitle, secondSlideTitle);
        set(this.thirdSlideTitle, thirdSlideTitle);
        set(this.firstSlideText, firstSlideText);
        set(this.secondSlideText, secondSlideText);
        set(this.thirdSlideText, thirdSlideText);
    }
}
