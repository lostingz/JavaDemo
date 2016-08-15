/**
 * lostingz
 * Created on 2016年8月15日
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
package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class LambdaTest {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
        List<String> list = Arrays.asList(atp);
        list.forEach((p) -> System.out.println(p));
        System.out.println("---------");
        list.forEach(System.out::println);
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(atp, (String s1, String s2) -> (s1.compareTo(s2)));
    }
}
