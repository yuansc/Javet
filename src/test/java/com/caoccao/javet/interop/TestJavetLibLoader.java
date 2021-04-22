/*
 *    Copyright 2021. caoccao.com Sam Cao
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package com.caoccao.javet.interop;

import com.caoccao.javet.enums.JSRuntimeType;
import com.caoccao.javet.exceptions.JavetLibraryNotLoadedException;
import org.junit.jupiter.api.Test;

public class TestJavetLibLoader {
    @Test
    public void testLoadAndUnload() {
        try {
            JavetClassLoader javetClassLoader = new JavetClassLoader(getClass().getClassLoader(), JSRuntimeType.Node);
            javetClassLoader.load();
            javetClassLoader = null;
            System.gc();
            System.runFinalization();
        } catch (JavetLibraryNotLoadedException e) {
            // This is expected.
        }
    }
}
