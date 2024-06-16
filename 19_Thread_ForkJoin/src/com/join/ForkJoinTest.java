package com.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

	public static void main(String[] args) {

		Claim[] claimArray = new Claim[400];
		for (int i = 0; i < claimArray.length; i++) {
			claimArray[i] = new Claim(1500.0);
		}

		ClaimProcessing cp = new ClaimProcessing(claimArray, 0, claimArray.length);
		ForkJoinPool forkPool = new ForkJoinPool();
		forkPool.execute(cp);

	}
}

class ClaimProcessing extends RecursiveTask<Double> {

	int startIndex;
	int lastIndex;
	int threshHold = 100;
	Claim[] claimsArray = null;

	public ClaimProcessing(Claim[] claims, int start, int end) {
		this.startIndex = start;
		this.lastIndex = end;
		this.claimsArray = claims;
	}

	@Override
	protected Double compute() {
		Double sum = 0.0;
		if ((lastIndex - startIndex) <= threshHold) {
			for (int i = 0; i < claimsArray.length; i++) {
				sum += claimsArray[i].getClaimAmt();
			}
		}
		else {
			int mid=lastIndex-(lastIndex-startIndex)/2;
			ClaimProcessing left=new ClaimProcessing(claimsArray, startIndex, mid);
			ClaimProcessing right=new ClaimProcessing(claimsArray, mid,lastIndex);
			left.fork();
			double rightSum=right.compute();
			double leftSum=left.join();
			
			return leftSum+rightSum;
		}
		System.out.println(sum);
		return sum;
	}

}

class Claim {

	private Double claimAmt;

	public Claim(Double claimAmt) {
		super();
		this.claimAmt = claimAmt;
	}

	public Double getClaimAmt() {
		return claimAmt;
	}

	public void setClaimAmt(Double claimAmt) {
		this.claimAmt = claimAmt;
	}

	@Override
	public String toString() {
		return "Claim [claimAmt=" + claimAmt + "]";
	}

}