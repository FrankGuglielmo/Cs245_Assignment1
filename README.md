# Cs245_Assignment1 - Part 1

Link to Running Time vs. Sorting algorithm Chart:

https://docs.google.com/spreadsheets/d/1lTCGVQwHRajd9ENvomshDcMTND17dfHQgiLYz6PSSvM/edit#gid=0

#Cs245_Assignment1 - Part 2

Description of the "Quicker than Merge" sort:

(To see code view BetterMerge2.java file) 

In this algorithm, I was able to utilize the same merge function as I did in MergeSort, as the
function for merging two arrays into one was pretty efficient and the most self-explanatory. 
However, the main challenge came in when deciphering where in the array should I create the
sorted subarrays, or sortedRegions, as I define them in my code. In my first attempt, I thought
it would be best to implement an ArrayList of double arrays to hold all the regions. However, I
noticed that this drastically increased the run time, as instead of being able to call a 
function like Arrays.copyOfRange(), I had to manually reinsert the values into the subarrays 
after already looping to find the indexes in the first place, creating an n^2 run just in finding
the sortedRegions. To remedy this, I simply kept tracked at the beginning and ending indexes of 
each sorted region and stored them into an ArrayList of integers. This allowed me to not only use
less loops, but would make it poosible to use Arrays.copyOfRange(), saving me a lot of time when
it came to finding the sortedRegions in the original array. As a result, this function, 
findSortedRegions(double [] arr), returned an ArrayList of all the starting and end points of
the original array. In terms of my sort function, by doing a lot of the work to find the 
sortedRegions in findSortedRegions(), all I had to do was create a left array, with my bounds 
being sortedRegions.get(0) and sortedRegions.get(1), and a right array, with the bounds being
sortedRegions.get(2) and sortedRegions.get(3). After getting the two arrays, I merged them into
arr like the old merge sort does. Once completed, I didn't need the ending index at 
sortedRegions.get(1) or the starting index at sortedRegions.get(2), so I removed them. This is 
because the new bounds of my sorted array started at sortedRegions.get(0) and ended at 
sortedRegions.get(3). I ran this same process until the size of my sortedRegions Arraylist was
lest than 2, with sortedRegions.get(0) and sortedRegions.get(1) being the bounds of the 
original array, only this time it was sorted.

