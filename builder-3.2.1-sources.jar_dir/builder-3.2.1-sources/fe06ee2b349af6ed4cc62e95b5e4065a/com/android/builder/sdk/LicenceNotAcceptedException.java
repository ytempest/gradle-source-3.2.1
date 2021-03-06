/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.android.builder.sdk;

import com.android.annotations.NonNull;
import com.android.repository.api.RemotePackage;
import com.google.common.collect.ImmutableList;
import java.nio.file.Path;
import java.util.List;

/**
 * Exception thrown when an SDK component cannot be installed as the licence was not accepted.
 *
 * @see InstallFailedException
 */
public final class LicenceNotAcceptedException extends Exception {

    private final ImmutableList<RemotePackage> affectedPackages;

    public LicenceNotAcceptedException(
            @NonNull Path sdkLocation, @NonNull List<RemotePackage> affectedPackages) {
        super(getMessage(sdkLocation, affectedPackages));
        this.affectedPackages = ImmutableList.copyOf(affectedPackages);
    }

    @NonNull
    private static String getMessage(
            @NonNull Path sdkLocation, @NonNull List<RemotePackage> affectedPackages) {
        StringBuilder builder =
                new StringBuilder(
                        "Failed to install the following Android SDK packages "
                                + "as some licences have not been accepted.\n");
        for (RemotePackage affectedPackage : affectedPackages) {
            builder.append("   ")
                    .append(affectedPackage.getPath())
                    .append(' ')
                    .append(affectedPackage.getDisplayName())
                    .append('\n');
        }
        builder.append(
                "To build this project, accept the SDK license agreements "
                        + "and install the missing components using the "
                        + "Android Studio SDK Manager.\n"
                        + "Alternatively, to transfer the license agreements from one "
                        + "workstation to another, see "
                        + "http://d.android.com/r/studio-ui/export-licenses.html\n"
                        + "\n"
                        + "Using Android SDK: ");
        builder.append(sdkLocation.toString());
        return builder.toString();
    }

    public List<RemotePackage> getAffectedPackages() {
        return affectedPackages;
    }
}
