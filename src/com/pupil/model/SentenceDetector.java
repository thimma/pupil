package com.pupil.model;

import java.io.*;

import opennlp.tools.*;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class SentenceDetector {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		POSModel model = new POSModelLoader().load(new File(
				"./WebContent/WEB-INF/lib/en-pos-maxent.bin"));
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);

		String input = "My name is Tom";
		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(input));

		perfMon.start();
		String line;
		while ((line = lineStream.read()) != null) {

			String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
					.tokenize(line);
			String[] tags = tagger.tag(whitespaceTokenizerLine);

			POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
			System.out.println(sample.toString());

			perfMon.incrementCounter();
		}
		perfMon.stopAndPrintFinalResult();
	}

	public static String partsOfSpeechDetector(String sentence) {
		POSModel model = new POSModelLoader().load(new File(
				"./WebContent/WEB-INF/lib/en-pos-maxent.bin"));
		//PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);

		String input = sentence;
		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(input));

		//perfMon.start();
		String line;
		POSSample sample=null;
		try {
			while ((line = lineStream.read()) != null) {

				String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
						.tokenize(line);
				String[] tags = tagger.tag(whitespaceTokenizerLine);

				sample = new POSSample(whitespaceTokenizerLine, tags);
				

				//perfMon.incrementCounter();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//perfMon.stopAndPrintFinalResult();
		return sample.toString();
	}
}
