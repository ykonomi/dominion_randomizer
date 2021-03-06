/*
 * Copyright 2017, The Android Open Source Project
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

package com.example.ykonomi.dominionrandomizer.data.source

import com.example.ykonomi.dominionrandomizer.data.Config

/**
 * Main entry point for accessing tasks data.
 *
 *
 * For simplicity, only getConfigs() and getConfig() have callbacks. Consider adding callbacks to other
 * methods to inform the user of network/database errors or successful operations.
 * For example, when a new task is created, it's synchronously stored in cache but usually every
 * operation on database or network should be executed in a different thread.
 */
interface ConfigsDataSource {

    interface LoadConfigsCallback {

        fun onConfigsLoaded(tasks: List<Config>)

        fun onDataNotAvailable()
    }

    interface GetConfigCallback {

        fun onConfigLoaded(task: Config)

        fun onDataNotAvailable()
    }

    fun getConfigs(callback: LoadConfigsCallback)

    fun getConfig(taskId: String, callback: GetConfigCallback)

    fun saveConfig(task: Config)

    fun completeConfig(task: Config)

    fun completeConfig(taskId: String)

    fun activateConfig(task: Config)

    fun activateConfig(taskId: String)

    fun clearCompletedConfigs()

    fun refreshConfigs()

    fun deleteAllConfigs()

    fun deleteConfig(taskId: String)
}
