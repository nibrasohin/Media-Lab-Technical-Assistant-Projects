class SimilarTest
{
	public static void main(String[] args)
	{
		//Just gonna print out the sum of all the possible odd numbers within a range

		int result=0;
		for(int i=0;i<500;i++)
		{
			if(i%2!=0)
			{
				result+=i;
			}
		}
		System.out.println("Result: "+result+"Some Change.");
	}
}