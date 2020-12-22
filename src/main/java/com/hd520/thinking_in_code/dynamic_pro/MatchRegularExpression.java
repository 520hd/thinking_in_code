package com.hd520.thinking_in_code.dynamic_pro;

/**
 * @Description 正则表达式的匹配
 * @Author xierishi
 * @Date 2020-12-22 23:52:14
 */
public class MatchRegularExpression {

	public boolean isMatch(String pattern, String word) {

		return dp(pattern, 0, word, 0);
	}

	private boolean dp(String pattern, int p, String word, int w) {

		// base case
		//    1) 当模式串匹配完之后, 目标字符串也匹配完成
		if (p == pattern.length()) {
			return w == word.length();
		}
		//    2) 当目标字符串匹配完的时候, 查看模式串是否可以匹配空串
		if (w == word.length()) {
			if ((pattern.length() - p + 1) % 2 != 0) {
				return false;
			}
			for (int i = p; i < pattern.length() - 1; i = i + 2) {
				if (pattern.charAt(i  + 1) != '*') {
					return false;
				}
			}
			return true;
		}
		// 将匹配的模式分为很多种
		// 1.pattern中含有.或者两者匹配时字符相等
		if (pattern.charAt(p) == '.' || pattern.charAt(p) == word.charAt(w)) {

			//   1)pattern下一个字符是* 匹配0个/或者继续往下匹配
			if (p < pattern.length() - 1 && pattern.charAt(p + 1) == '*') {
				return dp(pattern, p + 2, word, w) || dp(pattern, p, word, w + 1);
			} else {
				//   2)pattern下一个字符不是* 匹配一个
				return dp(pattern, p + 1, word, w + 1);
			}
		} else {
			// 2.pattern不含有.且匹配的时候字符不相等
			//   1)pattern下一个字符是* 匹配0个
			if (p < pattern.length() - 1 && pattern.charAt(p + 1) == '*') {
				return dp(pattern, p + 2, word, w);
			} else {
				//   2)pattern下一个字符不是* 匹配不了 返回false
				return false;
			}
		}
	}

	public static void main(String[] args) {

		MatchRegularExpression matchRegularExpression = new MatchRegularExpression();
		boolean match = matchRegularExpression.isMatch(".a*b", "cb");
		System.out.println(match);
	}
}
