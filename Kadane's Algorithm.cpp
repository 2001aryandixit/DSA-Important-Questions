#include<bits/stdc++.h>
using namespace std;

/*
  Author Lakshay Goel
  Github profile: https://github.com/MrLakshay
  Problem link: https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
  
  
  Exampple:
  Input:
  N = 5
  Arr[] = {1,2,3,-2,5}
  Output:
  9
  Explanation:
  Max subarray sum is 9
  of elements (1, 2, 3, -2, 5) which 
  is a contiguous subarray.
  */
 // } Driver Code Ends
class Solution{
    public:
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long long maxSubarraySum(int arr[], int n){
        
    long long max_ending = 0, max_so_far = INT_MIN;
    for (int i = 0; i < n; i++) {
       


        if (arr[i] <= max_ending + arr[i]) {
            max_ending += arr[i];
        }
       

        else {
            max_ending = arr[i];
        }
        if (max_ending > max_so_far)
            max_so_far = max_ending;
    }
    return max_so_far;
    }
    
};

// { Driver Code Starts.

int main()
{
    int t,n;
    
    cin>>t; //input testcases
    while(t--) //while testcases exist
    {
        
        cin>>n; //input size of array
        
        int a[n];
        
        for(int i=0;i<n;i++)
            cin>>a[i]; //inputting elements of array
            
        Solution ob;
        
        cout << ob.maxSubarraySum(a, n) << endl;
    }
}
  // } Driver Code Ends
