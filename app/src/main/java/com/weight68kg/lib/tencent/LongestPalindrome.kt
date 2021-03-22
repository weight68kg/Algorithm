//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"
class LongestPalindrome {

    fun longestPalindrome(s: String):

            String {
        return Solution2().longestPalindrome(s)
    }


    /**
     * 暴力解
     * 时间复杂度 O(n^3)
     * 空间复杂度 O(1)
     */
    inner

    class Solution1 {

        fun longestPalindrome(s: String):

                String {
            var maxLength = 0
            var result = ""
            for (i in 0..s.length) {
                for (j in i + 1..s.length) {
                    var palindrome = s.substring(i, j)
                    if (isPalindrome(palindrome)) {
                        if (palindrome.length > maxLength) {
                            maxLength = palindrome.length
                            result = palindrome
                        }
                    }
                }
            }
            return result
        }

        fun isPalindrome(s: String):

                Boolean {
            var isPalindrome = true
            for (i in 0..s.length / 2) {
                if (s[i] != s[s.length - i - 1]) {
                    return false
                }
            }
            return true
        }
    }

    inner

    class Solution2 {
        fun longestPalindrome(s: String):

                String {
            var maxLength = 0
            var result = ""

            if ("".equals(s)) {
                return ""
            }
            if (s.length == 1) {
                return s
            }

            if (s.length == 2 && s[0] == s[1]) {
                return s
            }
            for (i in 0..s.length) {
                val palindrome = getPalindrome(s, i, i)
                if (palindrome.length > maxLength) {
                    maxLength = palindrome.length
                    result = palindrome
                }
            }

            if ("".equals(result)) {
                result = s[0].toString()
            }
            return result
        }

        fun getPalindrome(s: String, left: Int, right: Int):

                String {
            var center = s.substring(left, right + 1)
            var same = false
            for (i in 0..center.length) {
                if (center[i] != center[0]) same = false
                same = true
            }

            var sameLeft = 0
            var sameRight = 0
            if (same) {

                center = getSameText(s, sameLeft, sameRight)
            }

            return center
        }

        fun getSameText(s: String, left: Int, right: Int):

                String {
            var finalLeft = left
            var finalRight = right
            if (left > 0) {
                if (s[left] == s[left - 1]) {
                    finalLeft -= 1
                }
            }
            if (right > 0) {
                if (s[right] == s[right + 1]) {
                    finalRight += 1
                }
            }
            return getSameText(s, finalLeft, finalRight)
        }
    }
}