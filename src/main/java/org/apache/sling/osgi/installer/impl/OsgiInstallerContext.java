/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.osgi.installer.impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.log.LogService;
import org.osgi.service.packageadmin.PackageAdmin;

/** Installer context, gives access to selected methods of the {@link OsgiInstallerImpl} */
public interface OsgiInstallerContext {
	BundleContext getBundleContext();
	PackageAdmin getPackageAdmin();
	ConfigurationAdmin getConfigurationAdmin();
	LogService getLogService();
	void incrementCounter(int index);
    void setCounter(int index, long value);
    Bundle getMatchingBundle(String bundleSymbolicName);
	
	/** Schedule a task for execution in the current OsgiController cycle */
	void addTaskToCurrentCycle(OsgiInstallerTask t);
	
	/** Schedule a task for execution in the next OsgiController cycle, 
	 * 	usually to indicate that a task must be retried 
	 */
	void addTaskToNextCycle(OsgiInstallerTask t);
}