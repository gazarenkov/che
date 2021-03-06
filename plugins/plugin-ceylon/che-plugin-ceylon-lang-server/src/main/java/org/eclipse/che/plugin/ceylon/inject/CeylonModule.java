/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.ceylon.inject;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.eclipse.che.api.project.server.handlers.ProjectHandler;
import org.eclipse.che.api.project.server.type.ProjectTypeDef;
import org.eclipse.che.inject.DynaModule;
import org.eclipse.che.plugin.ceylon.projecttype.CeylonProjectType;
import org.eclipse.che.plugin.ceylon.projecttype.CreateCeylonProjectHandler;

/** @author David Festal */
@DynaModule
public class CeylonModule extends AbstractModule {

  @Override
  protected void configure() {
    Multibinder<ProjectTypeDef> projectTypeMultibinder =
        Multibinder.newSetBinder(binder(), ProjectTypeDef.class);
    projectTypeMultibinder.addBinding().to(CeylonProjectType.class);

    Multibinder<ProjectHandler> projectHandlersMultibinder =
        Multibinder.newSetBinder(binder(), ProjectHandler.class);
    projectHandlersMultibinder.addBinding().to(CreateCeylonProjectHandler.class);
  }
}
