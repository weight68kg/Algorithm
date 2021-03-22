package com.weight68kg.lib.array

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray
import kotlin.math.max

/*1672. 最富有客户的资产总量
给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。

客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。

 

示例 1：

输入：accounts = [[1,2,3],[3,2,1]]
输出：6
解释：
第 1 位客户的资产总量 = 1 + 2 + 3 = 6
第 2 位客户的资产总量 = 3 + 2 + 1 = 6
两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
示例 2：

输入：accounts = [[1,5],[7,3],[3,5]]
输出：10
解释：
第 1 位客户的资产总量 = 6
第 2 位客户的资产总量 = 10
第 3 位客户的资产总量 = 8
第 2 位客户是最富有的，资产总量是 10
示例 3：

输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
输出：17
 

提示：

m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/richest-customer-wealth
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class MaximumWealth {
    fun run() {
        val intArray = Array(3) { IntArray(3) }
        intArray.set(0, intArrayOf(2, 8, 7))
        intArray.set(1, intArrayOf(7, 1, 3))
        intArray.set(2, intArrayOf(1, 9, 5))
        val maximumWealth = maximumWealth(intArray)
        println(maximumWealth)
    }


    private fun maximumWealth(accounts: Array<IntArray>): Int {
        var maximumWealth = 0
        var person = 0
//        for (index1 in accounts.indices) {
//            for (index2 in accounts[index1].indices) {
//                person += accounts[index1][index2]
//            }
//            if (maximumWealth < person) maximumWealth = person
//            person = 0
//        }
        val maxBy = accounts.maxBy {
            it.sum()
        }
        return maxBy?.sum()?:0
    }
}