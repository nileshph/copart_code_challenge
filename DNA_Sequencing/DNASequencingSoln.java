/**
 * 
 */
import java.util.Scanner;

/**
 * @author nayan
 *
 */
public class DNASequencingSoln {

	public static DNASequence[] longestDNASeq;
	
	public static void main(String[] args) {
		
		System.out.print("Please input the DNA Sequence:");
		Scanner scanner = new Scanner(System.in);
		String dna = scanner.next(); //new String("ATGGGCAAGGTT");//ATGGGCAAGGTT ACZZZAAA
		DNASequence dnaSequencing = null;

		int cntrDNASequenceArray = 0;
		int len = dna.length();
		longestDNASeq = new DNASequence[len +1];
		char currentSeq = ' ';
		int currentSeqLen = 0;
		int longestLen = 1;
		
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				if (currentSeq != dna.charAt(i)) {
					// check if currentSeqLen >= longestLen
					if (currentSeqLen >= longestLen) {
						// if currentSeqLen == longestLen
						if (currentSeqLen == longestLen) {
							// if it's not present, add this nucleotide to
							// longestDNASeq.
							if (!nucleotidePresent(currentSeq)) {
								dnaSequencing = new DNASequence();
								dnaSequencing.setNucleotide(currentSeq);
								dnaSequencing.setLenOfNucleotide(currentSeqLen);
								longestDNASeq[cntrDNASequenceArray++] = dnaSequencing;
								longestLen = currentSeqLen;
								currentSeq = dna.charAt(i);
								currentSeqLen = 1;
							}
						}
						// else if currentSeqLen > longestLen.
						else if (currentSeqLen > longestLen) {
							// set longestLen = currentSeqLen
							longestLen = currentSeqLen;
							// empty longestDNASeq, add this nucleotide to longestDNASeq.
							cntrDNASequenceArray = 0;
							dnaSequencing = new DNASequence();
							dnaSequencing.setNucleotide(currentSeq);
							dnaSequencing.setLenOfNucleotide(currentSeqLen);
							longestDNASeq[cntrDNASequenceArray++] = dnaSequencing;
							longestLen = currentSeqLen;
							currentSeq = dna.charAt(i);
							currentSeqLen = 1;
						}
					}

				} else {
					currentSeqLen++;
				}
			} else {
			currentSeq = dna.charAt(i);
			currentSeqLen = 1;
			}
		}

		if (currentSeqLen >= longestLen) {
			// if currentSeqLen == longestLen
			if (currentSeqLen == longestLen) {
				// if it's not present, add this nucleotide to
				// longestDNASeq.
				if (!nucleotidePresent(currentSeq)) {
					dnaSequencing = new DNASequence();
					dnaSequencing.setNucleotide(currentSeq);
					dnaSequencing.setLenOfNucleotide(currentSeqLen);
					longestDNASeq[cntrDNASequenceArray++] = dnaSequencing;
					longestLen = currentSeqLen;
				}
			}
			// else if currentSeqLen > longestLen.
			else if (currentSeqLen > longestLen) {
				// set longestLen = currentSeqLen
				longestLen = currentSeqLen;
				// empty longestDNASeq, add this nucleotide to longestDNASeq.
				cntrDNASequenceArray = 0;
				dnaSequencing = new DNASequence();
				dnaSequencing.setNucleotide(currentSeq);
				dnaSequencing.setLenOfNucleotide(currentSeqLen);
				longestDNASeq[cntrDNASequenceArray++] = dnaSequencing;
				longestLen = currentSeqLen;
			}
		}
		for (int j = 0; j < cntrDNASequenceArray; j++) {
			if (null != longestDNASeq[j])
			System.out.println(longestDNASeq[j].getNucleotide()+"\t"+longestDNASeq[j].getLenOfNucleotide());
		}
	}

	public static boolean nucleotidePresent(char seq) {
		for (DNASequence dnaSeq : longestDNASeq) {
			if (null != dnaSeq) {
				if (dnaSeq.getNucleotide() == seq) {
					return true;
				}
			}
		}
		return false;
	}
	
}
