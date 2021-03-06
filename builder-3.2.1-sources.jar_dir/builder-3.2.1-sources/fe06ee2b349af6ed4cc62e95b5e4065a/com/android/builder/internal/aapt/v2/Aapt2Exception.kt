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

package com.android.builder.internal.aapt.v2

/** Exception thrown when an error occurs during `aapt2` processing.  */
class Aapt2Exception @JvmOverloads constructor(
    val description: String,
    cause: Throwable? = null,
    val output: String? = null,
    val processName: String? = null,
    val command: String? = null
 ) : RuntimeException(makeMessage(description, output, processName, command), cause) {
    companion object {
        private const val serialVersionUID = 7034893190645766936L
    }
}
private fun makeMessage(description: String, output: String?, processName: String?, command: String?):String {
    if (output == null && processName == null && command == null) {
        return description
    }
    val stringBuilder = StringBuilder(description)
    if (output != null) {
        stringBuilder.append("\nOutput:  ").append(output)
    }
    if (command != null) {
        stringBuilder.append("\nCommand: ").append(command)
    }
    if (processName != null) {
        stringBuilder.append("\nDaemon:  ").append(processName)
    }
    return stringBuilder.toString()
}