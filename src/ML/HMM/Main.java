package ML.HMM;

import DA.Processing.DataDecoding;
import Util.Parser.JsonParser;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import java.util.Hashtable;
import java.util.Vector;

import org.json.*;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) throws Exception {
        JsonParser jp = new JsonParser("G:\\Github Repositories\\Hidden-Markov-Model\\Resources\\test_HMM.json");
        String name = DataDecoding.getInstance().getModelName(jp.getName());
        Vector<String> states = DataDecoding.getInstance().getStates(jp.getStates());
        Vector<String> observations = DataDecoding.getInstance().getObservations(jp.getObservations());
        Hashtable<String, Double> initialProbabilities = DataDecoding.getInstance().getInitialProbabilities(jp.getInitialProbabilities());
        Hashtable<Pair<String, String>, Double> transitionMatrix = DataDecoding.getInstance().getTransitionMatrix(jp.getTransitionMatrix());
        Hashtable<Pair<String, String>, Double> emissionMatrix = DataDecoding.getInstance().getEmissionMatrix(jp.getEmissionMatrix());

        HiddenMarkovModel hmm = new HiddenMarkovModel(name, states, observations, initialProbabilities, transitionMatrix, emissionMatrix);
        Vector<String>sampleStates = new Vector<String>();
        sampleStates.add("S");
        sampleStates.add("S");
        sampleStates.add("R");
        sampleStates.add("C");

        Vector<String> sampleO = new Vector<String>();
        sampleO.add("D");
        sampleO.add("F");
        sampleO.add("F");
        sampleO.add("U");

        System.out.println(hmm.evaluateUsingBruteForce(sampleStates, sampleO));
        System.out.println(hmm.evaluateUsingForward_Backward(sampleStates, sampleO));
        System.out.println(hmm.evaluateUsingForwardAlgorithm(sampleStates, sampleO));
    }

}
