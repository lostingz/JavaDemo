/**
 * lostingz
 * Created on 2016年8月9日
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.program;

import org.jsoup.Jsoup;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class MatchTest {
    public static void main(String[] args) {
        String input = "&bull;西藏民谣&amp;郭志明";
        String noHtml = Jsoup.parse(input).text();
        System.out.println(noHtml);
    }
}
