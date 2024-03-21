class Solution {
    fun minimumMoves(nums: IntArray, k: Int, maxChanges: Int): Long {
        val indices = nums.mapIndexed{i,e -> Pair(i,e)}.filter{it.second == 1}.map{it.first}
        val prefixSum = indices.scan(0L){a,e -> (a+e).toLong()}.drop(1)

        val INF = 1e15.toLong()


        fun getSum(l: Int, r: Int) : Long {
            if (r < l) return 0
            return prefixSum[r] - (if (l == 0) 0 else prefixSum[l-1])
        }

        fun op2Cost(remaining: Int) : Long {
            //println(indices)
            //println(prefixSum)
            if (remaining <= 0) return 0
            var li = 0; var ri = remaining-1;
            var ans = INF
            while (ri < indices.size) {
                val median = (li+ri)/2
                var cost = 0L
                cost += getSum(median+1, ri) - (ri - median)*indices[median]
                cost += (median-li)*indices[median] - getSum(li, median-1)
                ans = minOf(ans, cost)
                li += 1
                ri += 1
            }
            return ans
        }

        // this loop TLEs. Replace this with binary search (and pray that the cost function is unimodal)
        /*for (i in 0..minOf(k,maxChanges)) {
            val cost = i*2 // action1 + action2
            val remaining = k - i
            val op2 = op2Cost(remaining)
            ans = minOf(ans, cost + op2)
            //println("$ans, $cost, $op2, $remaining")
        }*/

        var l = 0; var r = minOf(k, maxChanges);
        while (l < r) {
            var m1 = (l+r)/2
            var m2 = m1+1
            val am1 = minOf(INF, m1*2 + op2Cost(k-m1))
            val am2 = minOf(INF, m2*2 + op2Cost(k-m2))
            if (am1 < am2) {
                r = m1
            } else {
                l = m2
            }
            //println("$l,$r,$m1,$m2")
        }

        return minOf(l*2+op2Cost(k-l), r*2+op2Cost(k-r))
    }
}

// [3,4,7,8]
// [0,1,2,3]
