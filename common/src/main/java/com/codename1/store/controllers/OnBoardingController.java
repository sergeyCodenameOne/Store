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

package com.codename1.store.controllers;

import com.codename1.rad.controllers.Controller;
import com.codename1.rad.controllers.FormController;
import com.codename1.rad.models.Entity;
import com.codename1.rad.nodes.Node;
import com.codename1.store.views.OnBoardingView;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

public class OnBoardingController extends FormController {
    /**
     * Creates a controller with a given parent controller.
     *
     * @param parent The parent controller of this controller.
     */
    public OnBoardingController(Controller parent, Entity onBoardingEntity, Node onBoardingNode) {
        super(parent);
        Form onBoardingForm = new Form(new BorderLayout());
        onBoardingForm.getToolbar().hideToolbar();
        onBoardingForm.add(BorderLayout.CENTER, new OnBoardingView(onBoardingEntity, onBoardingNode));


        setView(onBoardingForm);
    }
}
