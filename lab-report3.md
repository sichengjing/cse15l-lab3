# Part 1

# Part 2
In the ArrayExamples.java, there is a bug on the reversed method. 
![Image](3-1.png)
This image is the failure-inducing input. The arr.length is 5.
![Image](3-2.png)
After running the test, the output shows that it failed. To be specific, the symptom is the new array does not include the reversed elements of the input. However, it only contains 0. So, I need to debug.
![Image](3-3.png)
This image is the fixed code. I exchange the place of arr and newArray in line 19 and leave the others in this line unchanged. So, the last element of arr is the first item of newArray, and so on. Besides, I also change the return array into newArray.

In the given test example, because there is only no element in the input, so the problem is not obvious. After adding elements to the input, we can find where the bug is. Before the modification, newArray is empty, so it cannot give values to arr. So, the order of elements in arr is not changed, but all elements become 0.