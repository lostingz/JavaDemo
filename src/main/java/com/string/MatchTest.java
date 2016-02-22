/**
 * Chsi
 * Created on 2015年12月23日
 */
package com.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*//反斜杠
/t 间隔 ('/u0009')
/n 换行 ('/u000A')
/r 回车 ('/u000D')
/d 数字 等价于[0-9]
/D 非数字 等价于[^0-9]
/s 空白符号 [/t/n/x0B/f/r]
/S 非空白符号 [^/t/n/x0B/f/r]
/w 单独字符 [a-zA-Z_0-9]
/W 非单独字符 [^a-zA-Z_0-9]
/f 换页符
/e Escape
/b 一个单词的边界
/B 一个非单词的边界
/G 前一个匹配的结束

^为限制开头
^java     条件限制为以Java为开头字符
$为限制结尾
java$     条件限制为以java为结尾字符
.  条件限制除/n以外任意一个单独字符
java..     条件限制为java后除换行外任意两个字符


加入特定限制条件「[]」
[a-z]     条件限制在小写a to z范围中一个字符
[A-Z]     条件限制在大写A to Z范围中一个字符
[a-zA-Z] 条件限制在小写a to z或大写A to Z范围中一个字符
[0-9]     条件限制在小写0 to 9范围中一个字符
[0-9a-z] 条件限制在小写0 to 9或a to z范围中一个字符
[0-9[a-z]] 条件限制在小写0 to 9或a to z范围中一个字符(交集)

[]中加入^后加再次限制条件「[^]」
[^a-z]     条件限制在非小写a to z范围中一个字符
[^A-Z]     条件限制在非大写A to Z范围中一个字符
[^a-zA-Z] 条件限制在非小写a to z或大写A to Z范围中一个字符
[^0-9]     条件限制在非小写0 to 9范围中一个字符
[^0-9a-z] 条件限制在非小写0 to 9或a to z范围中一个字符
[^0-9[a-z]] 条件限制在非小写0 to 9或a to z范围中一个字符(交集)

在限制条件为特定字符出现0次以上时，可以使用「*」
J*     0个以上J
.*     0个以上任意字符
J.*D     J与D之间0个以上任意字符

在限制条件为特定字符出现1次以上时，可以使用「+」
J+     1个以上J
.+     1个以上任意字符
J.+D     J与D之间1个以上任意字符

在限制条件为特定字符出现有0或1次以上时，可以使用「?」
JA?     J或者JA出现

限制为连续出现指定次数字符「{a}」
J{2}     JJ
J{3}     JJJ
文字a个以上，并且「{a,}」
J{3,}     JJJ,JJJJ,JJJJJ,???(3次以上J并存)
文字个以上，b个以下「{a,b}」
J{3,5}     JJJ或JJJJ或JJJJJ
两者取一「|」
J|A     J或A
Java|Hello     Java或Hello

「()」中规定一个组合类型
*/

public class MatchTest {
    public static void main(String[] args) {
        String str = "阿克苏交电话费卡萨丁111111,asjdf*";
        String str1 = "0";
        String str2 = "0214134";
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str1);
        System.out.println(matcher.matches());

        Pattern pattern1 = Pattern.compile("[0-9]*");
        System.out.println(pattern1.matcher(str2).matches());

    }
}
