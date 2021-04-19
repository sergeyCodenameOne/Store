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

package com.codename1.store.views;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.rad.models.Entity;
import com.codename1.rad.models.Property;
import com.codename1.rad.nodes.ActionNode;
import com.codename1.rad.nodes.Node;
import com.codename1.rad.ui.AbstractEntityView;
import com.codename1.store.interfaces.OnBoarding;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

import static com.codename1.ui.CN.convertToPixels;
import static com.codename1.ui.util.Resources.getGlobalResources;

public class OnBoardingView extends AbstractEntityView {

    private static final EncodedImage placeHolder = EncodedImage.createFromImage(getGlobalResources().getImage("placeholder.png"), false);

    public static final ActionNode.Category LOGIN_BUTTON = new ActionNode.Category();
    public static final ActionNode.Category SIGN_UP_BUTTON = new ActionNode.Category();
    public static final ActionNode.Category APPLE_BUTTON = new ActionNode.Category();
    public static final ActionNode.Category GOOGLE_BUTTON = new ActionNode.Category();
    public static final ActionNode.Category FACEBOOK_BUTTON = new ActionNode.Category();

    Node viewNode;
    Property logoProp, firstSlideImageProp, secondSlideImageProp, thirdSlideImageProp, firstSlideTitleProp, secondSlideTitleProp, thirdSlideTitleProp, firstSlideTextProp, secondSlideTextProp, thirdSlideTextProp;

    public OnBoardingView(Entity onBoardingEntity, Node viewNode) {
        super(onBoardingEntity);
        this.viewNode = viewNode;
        setLayout(new BorderLayout());
        getAllStyles().setPadding(convertToPixels(2), convertToPixels(2), convertToPixels(2), convertToPixels(2));

        logoProp = onBoardingEntity.findProperty(OnBoarding.logo);
        firstSlideImageProp = onBoardingEntity.findProperty(OnBoarding.onBoardingFirstSlideImage);
        secondSlideImageProp = onBoardingEntity.findProperty(OnBoarding.onBoardingSecondSlideImage);
        thirdSlideImageProp = onBoardingEntity.findProperty(OnBoarding.onBoardingThirdSlideImage);
        firstSlideTitleProp = onBoardingEntity.findProperty(OnBoarding.onBoardingFirstSlideTitle);
        secondSlideTitleProp = onBoardingEntity.findProperty(OnBoarding.onBoardingSecondSlideTitle);
        thirdSlideTitleProp = onBoardingEntity.findProperty(OnBoarding.onBoardingThirdSlideTitle);
        firstSlideTextProp = onBoardingEntity.findProperty(OnBoarding.onBoardingFirstSlideText);
        secondSlideTextProp = onBoardingEntity.findProperty(OnBoarding.onBoardingSecondSlideText);
        thirdSlideTextProp = onBoardingEntity.findProperty(OnBoarding.onBoardingThirdSlideText);

        Image storeLogoImage = onBoardingEntity.createImageToStorage(logoProp, placeHolder);
        ScaleImageLabel logoLabel = new ScaleImageLabel(storeLogoImage){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = new Dimension();
                dim.setWidth(Display.getInstance().getDisplayWidth() / 2);
                dim.setHeight(dim.getWidth() / 3);
                return dim;
            }
        };
        logoLabel.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
        logoLabel.getAllStyles().setMargin(convertToPixels(2), convertToPixels(2), convertToPixels(2), convertToPixels(2));
        add(BorderLayout.NORTH, BorderLayout.centerAbsolute(logoLabel));

        Image firstSlideImage = onBoardingEntity.createImageToStorage(firstSlideImageProp, placeHolder);
        ScaleImageLabel firstSlideImageLabel = new ScaleImageLabel(firstSlideImage){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = new Dimension();
                dim.setWidth(Display.getInstance().getDisplayWidth());
                dim.setHeight(dim.getWidth() / 2);
                return dim;
            }
        };
        Label firstSlideTitleLabel = new Label(onBoardingEntity.getText(firstSlideTitleProp));
        Style firstSlideTitleStyle = firstSlideTitleLabel.getAllStyles();
        firstSlideTitleStyle.setAlignment(Component.CENTER);
        firstSlideTitleStyle.setPadding(convertToPixels(3), convertToPixels(1), convertToPixels(2), convertToPixels(2));
        firstSlideTitleStyle.setFont(UIManager.getInstance().getComponentStyle("HeaderFont").getFont());
        firstSlideTitleStyle.setFgColor(0x000000);
        SpanLabel firstSlideTextLabel = new SpanLabel(onBoardingEntity.getText(firstSlideTextProp));
        Style firstSlideTextStyle = firstSlideTextLabel.getTextComponent().getAllStyles();
        firstSlideTextStyle.setAlignment(Component.CENTER);
        firstSlideTextStyle.setPadding(convertToPixels(2), 0, convertToPixels(2), convertToPixels(2));
        firstSlideTextStyle.setFont(UIManager.getInstance().getComponentStyle("TextFont").getFont());
        firstSlideTextStyle.setFgColor(0x9a9a9a);
        Container firstSlideCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        firstSlideCnt.addAll(firstSlideImageLabel, firstSlideTitleLabel, firstSlideTextLabel);

        Image secondSlideImage = onBoardingEntity.createImageToStorage(secondSlideImageProp, placeHolder);
        ScaleImageLabel secondSlideImageLabel = new ScaleImageLabel(secondSlideImage){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = new Dimension();
                dim.setWidth(Display.getInstance().getDisplayWidth());
                dim.setHeight(dim.getWidth() / 2);
                return dim;
            }
        };
        Label secondSlideTitleLabel = new Label(onBoardingEntity.getText(secondSlideTitleProp));
        Style secondSlideTitleStyle = secondSlideTitleLabel.getAllStyles();
        secondSlideTitleStyle.setAlignment(Component.CENTER);
        secondSlideTitleStyle.setPadding(convertToPixels(3), convertToPixels(1), convertToPixels(2), convertToPixels(2));
        secondSlideTitleStyle.setFont(UIManager.getInstance().getComponentStyle("HeaderFont").getFont());
        secondSlideTitleStyle.setFgColor(0x000000);
        SpanLabel secondSlideTextLabel = new SpanLabel(onBoardingEntity.getText(secondSlideTextProp));
        Style secondSlideTextStyle = secondSlideTextLabel.getTextComponent().getAllStyles();
        secondSlideTextStyle.setAlignment(Component.CENTER);
        secondSlideTextStyle.setPadding(convertToPixels(2), 0, convertToPixels(2), convertToPixels(2));
        secondSlideTextStyle.setFont(UIManager.getInstance().getComponentStyle("TextFont").getFont());
        secondSlideTextStyle.setFgColor(0x9a9a9a);
        Container secondSlideCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        secondSlideCnt.addAll(secondSlideImageLabel, secondSlideTitleLabel, secondSlideTextLabel);


        Image thirdSlideImage = onBoardingEntity.createImageToStorage(thirdSlideImageProp, placeHolder);
        ScaleImageLabel thirdSlideImageLabel = new ScaleImageLabel(thirdSlideImage){
            @Override
            public Dimension getPreferredSize() {
                Dimension dim = new Dimension();
                dim.setWidth(Display.getInstance().getDisplayWidth());
                dim.setHeight(dim.getWidth() / 2);
                return dim;
            }
        };
        thirdSlideImageLabel.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
        Label thirdSlideTitleLabel = new Label(onBoardingEntity.getText(thirdSlideTitleProp));
        Style thirdSlideTitleStyle = thirdSlideTitleLabel.getAllStyles();
        thirdSlideTitleStyle.setAlignment(Component.CENTER);
        thirdSlideTitleStyle.setPadding(convertToPixels(3), convertToPixels(1), convertToPixels(2), convertToPixels(2));
        thirdSlideTitleStyle.setFont(UIManager.getInstance().getComponentStyle("HeaderFont").getFont());
        thirdSlideTitleStyle.setFgColor(0x000000);
        SpanLabel thirdSlideTextLabel = new SpanLabel(onBoardingEntity.getText(thirdSlideTextProp));
        Style thirdSlideTextStyle = thirdSlideTextLabel.getTextComponent().getAllStyles();
        thirdSlideTextStyle.setAlignment(Component.CENTER);
        thirdSlideTextStyle.setPadding(convertToPixels(2), 0, convertToPixels(2), convertToPixels(2));
        thirdSlideTextStyle.setFont(UIManager.getInstance().getComponentStyle("TextFont").getFont());
        thirdSlideTextStyle.setFgColor(0x9a9a9a);

        Container thirdSlideCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        thirdSlideCnt.addAll(thirdSlideImageLabel, thirdSlideTitleLabel, thirdSlideTextLabel);

        Tabs slides = new Tabs();
        slides.getAllStyles().setMargin(convertToPixels(3), 0, 0, 0);
        slides.getTabsContainer().setHidden(true);
        slides.getTabsContainer().setVisible(false);
        slides.addTab("", firstSlideCnt);
        slides.addTab("", secondSlideCnt);
        slides.addTab("", thirdSlideCnt);


        slides.setTabPlacement(Component.BOTTOM);
        add(BorderLayout.CENTER, slides);

        Button logInButton = new Button("LOG IN", "LoginButton");
        logInButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(LOGIN_BUTTON);
            if (action != null) {
                action.fireEvent(onBoardingEntity, OnBoardingView.this);
            }
        });
        Style loginButtonStyle = logInButton.getAllStyles();
        loginButtonStyle.setBgTransparency(0xff);
        loginButtonStyle.setMargin(convertToPixels(1), convertToPixels(1), convertToPixels(1), convertToPixels(1));
        loginButtonStyle.setPadding(convertToPixels(2), convertToPixels(2), convertToPixels(2), convertToPixels(2));
        loginButtonStyle.setBgColor(0x69bcfc);
        loginButtonStyle.setAlignment(Component.CENTER);
        loginButtonStyle.setFgColor(0xffffff);
        loginButtonStyle.setFont(UIManager.getInstance().getComponentStyle("HeaderFont").getFont());

        Button signUpButton = new Button("SIGN UP", "LoginButton");
        signUpButton.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(SIGN_UP_BUTTON);
            if (action != null) {
                action.fireEvent(onBoardingEntity, OnBoardingView.this);
            }
        });
        Style signUpButtonStyle = signUpButton.getAllStyles();
        signUpButtonStyle.setMargin(convertToPixels(1), convertToPixels(1), convertToPixels(1), convertToPixels(1));
        signUpButtonStyle.setPadding(convertToPixels(2), convertToPixels(2), convertToPixels(2), convertToPixels(2));
        signUpButtonStyle.setBgColor(UIManager.getInstance().getComponentStyle("SecondaryColor").getFgColor());
        signUpButtonStyle.setAlignment(Component.CENTER);
        signUpButtonStyle.setFgColor(0xffffff);

        signUpButtonStyle.setFont(UIManager.getInstance().getComponentStyle("HeaderFont").getFont());

        Container mainButtonsCnt = new Container(new GridLayout(2));
        mainButtonsCnt.addAll(logInButton, signUpButton);

        Label continueWithLabel = new Label("or continue with");
        Style continueWithStyle = continueWithLabel.getAllStyles();
        continueWithStyle.setAlignment(Component.CENTER);
        continueWithStyle.setPadding(convertToPixels(2), convertToPixels(2), convertToPixels(2), convertToPixels(2));
        continueWithStyle.setMargin(0, 0, 0, 0);
        continueWithStyle.setFgColor(0x000000);
        continueWithStyle.setFont(UIManager.getInstance().getComponentStyle("TextFont").getFont());

        Button signInWithFacebook = new Button("f");
        signInWithFacebook.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(FACEBOOK_BUTTON);
            if (action != null) {
                action.fireEvent(onBoardingEntity, OnBoardingView.this);
            }
        });

        Button signInWithGoogle = new Button("g");
        signInWithGoogle.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(GOOGLE_BUTTON);
            if (action != null) {
                action.fireEvent(onBoardingEntity, OnBoardingView.this);
            }
        });

        Button signInWithApple = new Button("a");
        signInWithApple.addActionListener(evt -> {
            evt.consume();
            ActionNode action = viewNode.getInheritedAction(APPLE_BUTTON);
            if (action != null) {
                action.fireEvent(onBoardingEntity, OnBoardingView.this);
            }
        });

        signInWithApple.getAllStyles().setPadding(1, 1, 1, 1);
        signInWithFacebook.getAllStyles().setPadding(1, 1, 1, 1);
        signInWithGoogle.getAllStyles().setPadding(1, 1, 1, 1);
        signInWithApple.getAllStyles().setMargin(0, 0, 0, 0);
        signInWithFacebook.getAllStyles().setMargin(0, 0, 0, 0);
        signInWithGoogle.getAllStyles().setMargin(0, 0, 0, 0);

        Container signingOptionsCnt = new Container(new BorderLayout());
        signingOptionsCnt.add(BorderLayout.NORTH, mainButtonsCnt);
        signingOptionsCnt.add(BorderLayout.CENTER, continueWithLabel);
        signingOptionsCnt.add(BorderLayout.SOUTH, FlowLayout.encloseCenter(signInWithFacebook, signInWithGoogle, signInWithApple));
        add(BorderLayout.SOUTH, signingOptionsCnt);
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public Node getViewNode() {
        return viewNode;
    }
}
