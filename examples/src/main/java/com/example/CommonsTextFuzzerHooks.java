// Copyright 2022 Code Intelligence GmbH
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.example;

import com.code_intelligence.jazzer.api.HookType;
import com.code_intelligence.jazzer.api.MethodHook;
import java.lang.invoke.MethodHandle;

public class CommonsTextFuzzerHooks {
    @MethodHook(type = HookType.REPLACE, targetClassName = "org.apache.commons.text.lookup.StringLookupFactory", targetMethod = "constantStringLookup")
    public static Object hookConstStringLookup(MethodHandle handle, Object thisObject, Object[] args, int hookId) {
        // Remove the ConstantStringLookup singleton to avoid the ReflectiveCall
        // sanitizer for this example
        return null;
    }
}