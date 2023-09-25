package Seating_Plan.src.planSeating;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; // import the ArrayList class
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public class Seating_Plan {
    public JFrame frame;
	public JTextField txtFDepartSeats; /* JTextField for displaying the departure seats */
	public JTextField TxtFTicketAmount_D;/* JTextField for displaying the selected ticket amount */
	public JTextField txtFReturnSeats; /* JTextField for displaying the return seats */
	/* array list created for storing return flight information */
	public static ArrayList<String> returnInfo = new ArrayList<String>();
	/* array list created for storing the departure flight information */
	public static ArrayList<String> departureInfo = new ArrayList<String>();
	/* array list created for storing seats selected for Departures Airbus747 */
	public static HashSet<String> selectedSeatsDepartA = new HashSet<String>();
	/* array list created for storing the selected seats for Return Airbus747 */
	public static HashSet<String> selectedSeatsReturnA = new HashSet<String>();
	/* array list created for storing the selected seats for Departure boeing747 */
	public static HashSet<String> selectedSeatsDepartB = new HashSet<String>();
	/* array list created for storing the selected seats for return Boeing747 */
	public static HashSet<String> selectedSeatsReturnB = new HashSet<String>();
	/* array list created for compressing seats selected departure list */
	public static HashSet<String> seatsDepart = new HashSet<String>();
	/* array list created for compressing seats selected return list */
	public static HashSet<String> seatsReturn = new HashSet<String>();
	/* this stores the selected ticket amount */
	public static ArrayList<String> ticketAmountA = new ArrayList<String>();
	public static double fDuration = 561;
	/*
	 * this variable will contain how long the flight should be, converted from
	 * minutes into hours
	 */
	public static int ticketAmount_D = 1; /* stores the ticket amounts for departure */
	public static int ticketAmount_R = 1; /* stores ticket amount for return */
	public static int departandReturnTicket = 0; /* stores ticket amount for both departure and return */
	public static int seatDisplay = 1; /* helps determine what seats should be displayed */
	public static int loopSeatingPlan = 0; /* used for looping or reopening the seating plan twice */
	public static int seatNumber = 0; /* stores the total amount of seats */
	public static String ticketAmounts; /* this stores the string version of ticketAmount_D and ticketAmount_R */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * this is used for calling a non static method and in static void main method
		 */
		Seating_Plan Alg1 = new Seating_Plan();
		Alg1.longAndShortHaulFlights();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seating_Plan window = new Seating_Plan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	public void longAndShortHaulFlights() {
		/*
		 * this method places values with variables depending on the duration of the
		 * flight
		 */

		/* this is written in minutes */
		if (fDuration >= 120) { /* if the flight duration is more then or equal to 2 hours */
			seatDisplay = +1; /* adds 1 to seat display */
			seatNumber = 84; /* total number of seats in boeing747 */

		} else { /* if the flight duration variable is less then 2 hours */
			seatDisplay = +2; /* adds 2 to seatDisplay */
			seatNumber = 64; /* total number of seats in AirbusA138 */

		}

	}

	/**
	 * Create the application.
	 */
	public Seating_Plan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() { /* the UI creation */

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 180, 209));
		frame.setBounds(100, 100, 1036, 988);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// ticketAmount panel
		JPanel ticketAmountPanel = new JPanel();
		ticketAmountPanel.setBorder(new LineBorder(Color.BLACK, 2));
		ticketAmountPanel.setForeground(Color.BLACK);
		ticketAmountPanel.setBackground(Color.WHITE);
		ticketAmountPanel.setBounds(576, 500, 344, 108);
		frame.getContentPane().add(ticketAmountPanel);
		ticketAmountPanel.setLayout(null);

		// label for ticket amount
		JLabel lblTicketAmount_D = new JLabel("Ticket Amount Depart");
		lblTicketAmount_D.setBounds(74, 16, 188, 37);
		ticketAmountPanel.add(lblTicketAmount_D);
		lblTicketAmount_D.setForeground(Color.BLACK);
		lblTicketAmount_D.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// text field for ticket amount
		TxtFTicketAmount_D = new JTextField();
		TxtFTicketAmount_D.setEditable(false);
		TxtFTicketAmount_D.setBounds(146, 64, 49, 37);
		ticketAmountPanel.add(TxtFTicketAmount_D);
		TxtFTicketAmount_D.setColumns(3);

		// -----------------------------------------------------------------------------------------------------------------
		// button minus for ticket amount
		JButton btnMinus = new JButton("Minus"); /* creates a button called btnMinus and names the label Minus */
		JButton btnPlus = new JButton("Plus"); /* creates a button called btnPlus and names the label Plus */

		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {
					ticketAmount_D -= 1;

					/*
					 * changes variable integer to string variable for adding to a array list for
					 * display
					 */
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_D).replace('[', ' ').replace(']', ' '));
					ticketAmountA.add(ticketAmounts);
					/*
					 * adds and removes ticketAmounts from array list for every button pressed
					 * (alternative for refreshing/updating)
					 */
					ticketAmountA.remove(ticketAmounts);

				} else {

					ticketAmount_R -= 1;

					/*
					 * changes variable integer to string variable for adding to a array list for
					 * display
					 */
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_R).replace('[', ' ').replace(']', ' '));
					ticketAmountA.add(ticketAmounts);
					/*
					 * adds and removes ticketAmounts from array list for every button pressed
					 * (alternative for refreshing/updating)
					 */
					ticketAmountA.remove(ticketAmounts);

				}

				if (loopSeatingPlan == 0) {

					if (ticketAmount_D <= 0) {

						JOptionPane.showMessageDialog(frame, "You cannot go bellow 0",
								"Press the Plus button to go above 0", JOptionPane.ERROR_MESSAGE);

						btnMinus.setEnabled(false);
						btnPlus.setEnabled(true);
					}

					else if (ticketAmount_D != 0 || ticketAmount_D != seatNumber) {
						btnMinus.setEnabled(true);
						btnPlus.setEnabled(true);
					}
				}

				else {

					if (ticketAmount_R <= 0) {

						JOptionPane.showMessageDialog(frame, "You cannot go bellow 0",
								"Press the Plus button to go above 0", JOptionPane.ERROR_MESSAGE);

						btnMinus.setEnabled(false);
						btnPlus.setEnabled(true);
					}

					else if (ticketAmount_R != 0 || ticketAmount_R != seatNumber) {
						btnMinus.setEnabled(true);
						btnPlus.setEnabled(true);
					}

				}

			}
		});
		// -----------------------------------------------------------------------------------------------------------------
		// button plus for ticket amount

		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {

					ticketAmount_D += 1; /* for time the button is pressed it will add 1 to the */

					/*
					 * changes variable integer to string variable for adding to a array list for
					 * display
					 */
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_D).replace('[', ' ').replace(']', ' '));
					ticketAmountA.add(ticketAmounts);
					/*
					 * adds and removes ticketAmounts from array list for every button pressed
					 * (alternative to refreshing/updating)
					 */
					ticketAmountA.remove(ticketAmounts);

				}

				else {

					ticketAmount_R += 1; /* for time the button is pressed it will add 1 to the */

					/*
					 * changes variable integer to string variable for adding to a array list for
					 * display
					 */
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_R).replace('[', ' ').replace(']', ' '));
					ticketAmountA.add(ticketAmounts);
					/*
					 * adds and removes ticketAmounts from array list for every button pressed
					 * (alternative to refreshing/updating)
					 */
					ticketAmountA.remove(ticketAmounts);

				}

				if (loopSeatingPlan == 0) {
					if (ticketAmount_D >= seatNumber) {
						/*
						 * if ticketAmoutn is more then seatNumber then an error message should appear
						 */

						JOptionPane.showMessageDialog(frame, "You cannot go above the total amount of seats ",
								"Press the minus button to go down",
								JOptionPane.ERROR_MESSAGE); /* warning message appears if ticketAMount = less then 0 */

						btnPlus.setEnabled(false); /* this disables the button so the user cannot go bellow 0 */
						btnMinus.setEnabled(true);
					}

					else if (ticketAmount_D != seatNumber || ticketAmount_D != -1) {
						/* re enables the button if the condition is */

						btnPlus.setEnabled(true);
						btnMinus.setEnabled(true);
					}

				}

				else {
					if (ticketAmount_R >= seatNumber) {
						/*
						 * if ticketAmoutn is more then seatNumber then an error message should appear
						 */

						JOptionPane.showMessageDialog(frame, "You cannot go above the total amount of seats",
								"Press the Minus button to go down",
								JOptionPane.ERROR_MESSAGE); /* warning message appears if ticketAMount = less then 0 */

						btnPlus.setEnabled(false); /* disables the button */
						btnMinus.setEnabled(true);
					}

					else if (ticketAmount_R != seatNumber
							|| ticketAmount_R != -1) { /* re enables the button if the condition is */

						btnPlus.setEnabled(true);
						btnMinus.setEnabled(true);
					}

				}
			}
		});
		btnMinus.setBounds(208, 64, 130, 37);
		ticketAmountPanel.add(btnMinus);
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPlus.setBounds(6, 62, 130, 40);
		ticketAmountPanel.add(btnPlus);
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel seatSelectionPanel = new JPanel();
		seatSelectionPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		seatSelectionPanel.setBackground(Color.WHITE);
		seatSelectionPanel.setBounds(566, 223, 434, 256);
		frame.getContentPane().add(seatSelectionPanel);
		seatSelectionPanel.setLayout(null);
		// ----------------------------------------------------------------------------------------
		// label for seat selections section
		JLabel lblSeatSelection = new JLabel("Seat Selection");
		lblSeatSelection.setBounds(156, 11, 111, 37);
		seatSelectionPanel.add(lblSeatSelection);
		lblSeatSelection.setForeground(Color.BLACK);
		lblSeatSelection.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// ---------------------------------------------------------------------------------------
		// label for departure seat numbers list
		JLabel lblListDepartSeat = new JLabel("List of all chosen seats for Departure Flight");
		lblListDepartSeat.setBounds(10, 48, 351, 37);
		seatSelectionPanel.add(lblListDepartSeat);
		lblListDepartSeat.setForeground(Color.BLACK);
		lblListDepartSeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// text field for departure seat numbers list
		txtFDepartSeats = new JTextField();
		txtFDepartSeats.setBounds(10, 83, 411, 37);
		seatSelectionPanel.add(txtFDepartSeats);
		txtFDepartSeats.setEditable(false);
		txtFDepartSeats.setColumns(10);

		// ----------------------------------------------------------------------------------------
		// label for return seat numbers list
		JLabel lblListReturnSeats = new JLabel("List of all chosen seats for Return Flight");
		lblListReturnSeats.setBounds(10, 170, 315, 37);
		seatSelectionPanel.add(lblListReturnSeats);
		lblListReturnSeats.setForeground(Color.BLACK);
		lblListReturnSeats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		// text field for return seat numbers list
		txtFReturnSeats = new JTextField();
		txtFReturnSeats.setBounds(10, 208, 411, 37);
		seatSelectionPanel.add(txtFReturnSeats);
		txtFReturnSeats.setEditable(false);
		txtFReturnSeats.setColumns(10);

		// creates a panel that shows the bclLogo
		JPanel bclLogo = new JPanel();
		bclLogo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bclLogo.setBounds(613, 11, 319, 187);
		frame.getContentPane().add(bclLogo);
		bclLogo.setLayout(null);
		// displays the imageLogo
		JLabel imgLogo = new JLabel("New label");
		imgLogo.setBackground(Color.WHITE);
		imgLogo.setBounds(17, 11, 292, 166);
		bclLogo.add(imgLogo);
		imgLogo.setIcon(new ImageIcon("C:\\Users\\Guest 1\\Downloads\\bcl_logo.jpeg"));

		// a page that allows you to go back and change options
		JPanel plBack = new JPanel();
		plBack.setBorder(new LineBorder(Color.BLACK, 2));
		plBack.setBounds(0, 0, 547, 955);
		frame.getContentPane().add(plBack);
		plBack.setLayout(null);
		// button to go back a page

		// AIRBUS SEATING PLAN - start
		// {
		JPanel AirbusA318SeatingPlan = new JPanel();
		AirbusA318SeatingPlan.setBorder(new LineBorder(Color.BLACK, 2));
		AirbusA318SeatingPlan.setBounds(0, 0, 547, 955);
		frame.getContentPane().add(AirbusA318SeatingPlan);
		AirbusA318SeatingPlan.setBackground(Color.WHITE);
		AirbusA318SeatingPlan.setForeground(Color.BLACK);
		AirbusA318SeatingPlan.setLayout(null);
		// creates a btnContinue for airbusa318

		JButton btnContinue_A = new JButton("Continue");
		// creates a btnBack for Airbusa318

		JButton btnBack_A = new JButton("Back");

		JLabel lblReturnFlightSeats_A = new JLabel("Return Flight Seats");
		lblReturnFlightSeats_A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReturnFlightSeats_A.setBounds(173, 85, 205, 55);
		AirbusA318SeatingPlan.add(lblReturnFlightSeats_A);

		JLabel lblDepartureFlightSeats_A = new JLabel("Departure Flight Seats");
		lblDepartureFlightSeats_A.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepartureFlightSeats_A.setBounds(173, 85, 205, 55);
		AirbusA318SeatingPlan.add(lblDepartureFlightSeats_A);

		JTextPane txtLAirbusA318 = new JTextPane();
		txtLAirbusA318.setEditable(false);
		txtLAirbusA318.setBounds(149, 28, 246, 32);
		AirbusA318SeatingPlan.add(txtLAirbusA318);
		txtLAirbusA318.setForeground(Color.BLACK);
		txtLAirbusA318.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtLAirbusA318.setBackground(Color.GRAY);
		txtLAirbusA318.setText("         Airbus A318");

		JLabel lblBusinessClass = new JLabel("Business Class");
		lblBusinessClass.setForeground(Color.BLACK);
		lblBusinessClass.setEnabled(false);
		lblBusinessClass.setBackground(Color.BLACK);
		lblBusinessClass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBusinessClass.setBounds(25, 55, 111, 25);
		AirbusA318SeatingPlan.add(lblBusinessClass);

		// 1A -1A Button
		JToggleButton btn1A_A = new JToggleButton("1A");
		btn1A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* if btn1 is pressed for airbusA138 then the actions bellow would occur */

				if (loopSeatingPlan == 0) {
					/* this will detect whether the user is on the departures page or return page */

					if (btn1A_A.isSelected()) { /* if the button is selected */

						selectedSeatsDepartA.add("1A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {/* if the button is unselected */
						/* removes the the string "1A" from the array list */

						selectedSeatsDepartA.remove("1A");
						/*
						 * displays the array list containing the selected seats for boeing747 departure
						 * displayed within a text field
						 */
						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {
					/*
					 * this executables bellow are used for the return page of boeing747 seating
					 * Plan
					 */

					if (btn1A_A.isSelected()) {

						selectedSeatsReturnA.add("1A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));

					}

					else { /* if the button is unselected */
						selectedSeatsReturnA.remove("1A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn1A_A.setForeground(Color.BLACK);
		btn1A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1A_A.setBackground(Color.LIGHT_GRAY);
		btn1A_A.setBounds(40, 100, 65, 30);
		AirbusA318SeatingPlan.add(btn1A_A);

		// 1B -1B Button
		JToggleButton btn1B_A = new JToggleButton("1B");
		btn1B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn1B_A.isSelected()) {

						selectedSeatsDepartA.add("1B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("1B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn1B_A.isSelected()) {

						selectedSeatsReturnA.add("1B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("1B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn1B_A.setForeground(Color.BLACK);
		btn1B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1B_A.setBackground(Color.LIGHT_GRAY);
		btn1B_A.setBounds(465, 97, 65, 30);
		AirbusA318SeatingPlan.add(btn1B_A);

		// 2A -2A Button
		JToggleButton btn2A_A = new JToggleButton("2A");
		btn2A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {

					if (btn2A_A.isSelected()) {

						selectedSeatsDepartA.add("2A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("2A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn2A_A.isSelected()) {

						selectedSeatsReturnA.add("2A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("2A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});

		btn2A_A.setForeground(Color.BLACK);
		btn2A_A.setBackground(Color.LIGHT_GRAY);
		btn2A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2A_A.setBounds(40, 140, 65, 30);
		AirbusA318SeatingPlan.add(btn2A_A);

		// 2B -2B Button
		JToggleButton btn2B_A = new JToggleButton("2B");
		btn2B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {

					if (btn2B_A.isSelected()) {

						selectedSeatsDepartA.add("2B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("2B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else { // if th

					if (btn2B_A.isSelected()) {

						selectedSeatsReturnA.add("2B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("2B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn2B_A.setForeground(Color.BLACK);
		btn2B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2B_A.setBackground(Color.LIGHT_GRAY);
		btn2B_A.setBounds(465, 140, 65, 30);
		AirbusA318SeatingPlan.add(btn2B_A);

		// 3A -3A Button
		JToggleButton btn3A_A = new JToggleButton("3A");
		btn3A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn3A_A.isSelected()) {

						selectedSeatsDepartA.add("2B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("2B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn3A_A.isSelected()) {

						selectedSeatsReturnA.add("2B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("2B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn3A_A.setForeground(Color.BLACK);
		btn3A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn3A_A.setBackground(Color.LIGHT_GRAY);
		btn3A_A.setBounds(40, 180, 65, 30);
		AirbusA318SeatingPlan.add(btn3A_A);

		JToggleButton btn3B_A = new JToggleButton("3B");
		btn3B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {

					if (btn3B_A.isSelected()) {

						selectedSeatsDepartA.add("3B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("3B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn3B_A.isSelected()) {

						selectedSeatsReturnA.add("3B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("3B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn3B_A.setForeground(Color.BLACK);
		btn3B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn3B_A.setBackground(Color.LIGHT_GRAY);
		btn3B_A.setBounds(465, 185, 65, 30);
		AirbusA318SeatingPlan.add(btn3B_A);

		JButton btn4A_A = new JButton("4A");
		btn4A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				} else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btn4A_A.setForeground(Color.BLACK);
		btn4A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn4A_A.setBackground(Color.RED);
		btn4A_A.setBounds(40, 220, 65, 30);
		AirbusA318SeatingPlan.add(btn4A_A);

		JToggleButton btn4B_A = new JToggleButton("4B");
		btn4B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn4B_A.isSelected()) {

						selectedSeatsDepartA.add("4B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("4B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn4B_A.isSelected()) {

						selectedSeatsReturnA.add("4B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("4B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});

		btn4B_A.setForeground(Color.BLACK);
		btn4B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn4B_A.setBackground(Color.LIGHT_GRAY);
		btn4B_A.setBounds(465, 228, 65, 30);
		AirbusA318SeatingPlan.add(btn4B_A);

		JButton btn5A_A = new JButton("5A");
		btn5A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				} else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btn5A_A.setForeground(Color.BLACK);
		btn5A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5A_A.setBackground(Color.RED);
		btn5A_A.setBounds(40, 260, 65, 30);
		AirbusA318SeatingPlan.add(btn5A_A);

		JToggleButton btn5B_A = new JToggleButton("5B");
		btn5B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);
				}

				else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btn5B_A.setForeground(Color.BLACK);
		btn5B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5B_A.setBackground(Color.LIGHT_GRAY);
		btn5B_A.setBounds(465, 271, 65, 30);
		AirbusA318SeatingPlan.add(btn5B_A);

		JLabel lblEconomy = new JLabel("Economy");
		lblEconomy.setBackground(Color.BLACK);
		lblEconomy.setEnabled(false);
		lblEconomy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEconomy.setBounds(25, 305, 100, 25);
		AirbusA318SeatingPlan.add(lblEconomy);

		JToggleButton btn6A_A = new JToggleButton("6A");
		btn6A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn6A_A.isSelected()) {

						selectedSeatsDepartA.add("6A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("6A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn6A_A.isSelected()) {

						selectedSeatsReturnA.add("6A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("6A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6A_A.setForeground(Color.BLACK);
		btn6A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6A_A.setBackground(Color.LIGHT_GRAY);
		btn6A_A.setBounds(40, 345, 65, 30);
		AirbusA318SeatingPlan.add(btn6A_A);

		JToggleButton btn6B_A = new JToggleButton("6B");
		btn6B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn6B_A.isSelected()) {

						selectedSeatsDepartA.add("6B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("6B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn6B_A.isSelected()) {

						selectedSeatsReturnA.add("6B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("6B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6B_A.setForeground(Color.BLACK);
		btn6B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6B_A.setBackground(Color.LIGHT_GRAY);
		btn6B_A.setBounds(115, 345, 65, 30);
		AirbusA318SeatingPlan.add(btn6B_A);

		JToggleButton btn6C_A = new JToggleButton("6C");
		btn6C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn6C_A.isSelected()) {

						selectedSeatsDepartA.add("6C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("6C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn6C_A.isSelected()) {

						selectedSeatsReturnA.add("6C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("6C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6C_A.setForeground(Color.BLACK);
		btn6C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6C_A.setBackground(Color.LIGHT_GRAY);
		btn6C_A.setBounds(190, 345, 65, 30);
		AirbusA318SeatingPlan.add(btn6C_A);

		JToggleButton btn6D_A = new JToggleButton("6D");
		btn6D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn6D_A.isSelected()) {

						selectedSeatsDepartA.add("6D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("6D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn6D_A.isSelected()) {

						selectedSeatsReturnA.add("6D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("6D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6D_A.setForeground(Color.BLACK);
		btn6D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6D_A.setBackground(Color.LIGHT_GRAY);
		btn6D_A.setBounds(315, 345, 65, 30);
		AirbusA318SeatingPlan.add(btn6D_A);

		JToggleButton btn6E_A = new JToggleButton("6E");
		btn6E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn6E_A.isSelected()) {

						selectedSeatsDepartA.add("6E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("6E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn6E_A.isSelected()) {

						selectedSeatsReturnA.add("6E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("6E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6E_A.setForeground(Color.BLACK);
		btn6E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6E_A.setBackground(Color.LIGHT_GRAY);
		btn6E_A.setBounds(390, 345, 65, 30);
		AirbusA318SeatingPlan.add(btn6E_A);

		JToggleButton btn6F_A = new JToggleButton("6F");
		btn6F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					// if (btn6F_A.isSelected()) {

					// selectedSeatsDepartA.add("6F");
					//
					// txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[','
					// ').replace(']',' '));
					// }

					// else {
					// selectedSeatsDepartA.remove("6F");
					//
					// txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[','
					// ').replace(']',' '));
					// }

				} else {

					// if (btn6F_A.isSelected()) {

					// selectedSeatsReturnA.add("6F");
					///
					// txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[','
					// ').replace(']',' '));
					// }

					// else {
					// selectedSeatsReturnA.remove("6F");
					//
					// txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[','
					// ').replace(']',' '));
					// }
				}
			}
		});
		btn6F_A.setForeground(Color.BLACK);
		btn6F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6F_A.setBackground(Color.LIGHT_GRAY);
		btn6F_A.setBounds(465, 345, 65, 30);
		AirbusA318SeatingPlan.add(btn6F_A);

		JToggleButton btn7A_A = new JToggleButton("7A");
		btn7A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn7A_A.isSelected()) {

						selectedSeatsDepartA.add("7A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("7A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn7A_A.isSelected()) {

						selectedSeatsReturnA.add("7A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("7A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7A_A.setForeground(Color.BLACK);
		btn7A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7A_A.setBackground(Color.LIGHT_GRAY);
		btn7A_A.setBounds(40, 385, 65, 30);
		AirbusA318SeatingPlan.add(btn7A_A);

		JToggleButton btn7B_A = new JToggleButton("7B");
		btn7B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn7B_A.isSelected()) {

						selectedSeatsDepartA.add("7B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("7B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn7B_A.isSelected()) {

						selectedSeatsReturnA.add("7B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("7B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7B_A.setForeground(Color.BLACK);
		btn7B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7B_A.setBackground(Color.LIGHT_GRAY);
		btn7B_A.setBounds(115, 385, 65, 30);
		AirbusA318SeatingPlan.add(btn7B_A);

		JToggleButton btn7C_A = new JToggleButton("7C");
		btn7C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn7C_A.isSelected()) {

						selectedSeatsDepartA.add("7C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("7C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn7C_A.isSelected()) {

						selectedSeatsReturnA.add("7C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("7C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7C_A.setForeground(Color.BLACK);
		btn7C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7C_A.setBackground(Color.LIGHT_GRAY);
		btn7C_A.setBounds(190, 385, 65, 32);
		AirbusA318SeatingPlan.add(btn7C_A);

		JToggleButton btn7D_A = new JToggleButton("7D");
		btn7D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn7D_A.isSelected()) {

						selectedSeatsDepartA.add("7D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("7D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn7D_A.isSelected()) {

						selectedSeatsReturnA.add("7D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("7D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7D_A.setForeground(Color.BLACK);
		btn7D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7D_A.setBackground(Color.LIGHT_GRAY);
		btn7D_A.setBounds(315, 385, 65, 30);
		AirbusA318SeatingPlan.add(btn7D_A);

		JToggleButton btn7E_A = new JToggleButton("7E");
		btn7E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn7E_A.isSelected()) {

						selectedSeatsDepartA.add("7E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("7E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn7E_A.isSelected()) {

						selectedSeatsReturnA.add("7E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("7E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7E_A.setForeground(Color.BLACK);
		btn7E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7E_A.setBackground(Color.LIGHT_GRAY);
		btn7E_A.setBounds(390, 385, 65, 30);
		AirbusA318SeatingPlan.add(btn7E_A);

		JToggleButton btn7F_A = new JToggleButton("7F");
		btn7F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn7F_A.isSelected()) {

						selectedSeatsDepartA.add("7F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("7F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn7F_A.isSelected()) {

						selectedSeatsReturnA.add("7F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("7F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7F_A.setForeground(Color.BLACK);
		btn7F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7F_A.setBackground(Color.LIGHT_GRAY);
		btn7F_A.setBounds(465, 385, 68, 32);
		AirbusA318SeatingPlan.add(btn7F_A);

		JToggleButton btn8A_A = new JToggleButton("8A");
		btn8A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn8A_A.isSelected()) {

						selectedSeatsDepartA.add("8A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("8A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn8A_A.isSelected()) {

						selectedSeatsReturnA.add("8A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("8A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8A_A.setForeground(Color.BLACK);
		btn8A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8A_A.setBackground(Color.LIGHT_GRAY);
		btn8A_A.setBounds(40, 425, 65, 30);
		AirbusA318SeatingPlan.add(btn8A_A);

		JToggleButton btn8B_A = new JToggleButton("8B");
		btn8B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn8B_A.isSelected()) {

						selectedSeatsDepartA.add("8B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("8B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn8B_A.isSelected()) {

						selectedSeatsReturnA.add("8B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("8B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8B_A.setForeground(Color.BLACK);
		btn8B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8B_A.setBackground(Color.LIGHT_GRAY);
		btn8B_A.setBounds(115, 425, 65, 32);
		AirbusA318SeatingPlan.add(btn8B_A);

		JToggleButton btn8C_A = new JToggleButton("8C");
		btn8C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn8C_A.isSelected()) {

						selectedSeatsDepartA.add("8C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("8C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn8C_A.isSelected()) {

						selectedSeatsReturnA.add("8C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("8C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8C_A.setForeground(Color.BLACK);
		btn8C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8C_A.setBackground(Color.LIGHT_GRAY);
		btn8C_A.setBounds(190, 425, 65, 30);
		AirbusA318SeatingPlan.add(btn8C_A);

		JToggleButton btn8D_A = new JToggleButton("8D");
		btn8D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn8D_A.isSelected()) {

						selectedSeatsDepartA.add("8D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("8D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn8D_A.isSelected()) {

						selectedSeatsReturnA.add("8D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("8D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8D_A.setForeground(Color.BLACK);
		btn8D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8D_A.setBackground(Color.LIGHT_GRAY);
		btn8D_A.setBounds(315, 425, 65, 30);
		AirbusA318SeatingPlan.add(btn8D_A);

		JToggleButton btn8E_A = new JToggleButton("8E");
		btn8E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn8E_A.isSelected()) {

						selectedSeatsDepartA.add("8E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("8E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn8E_A.isSelected()) {

						selectedSeatsReturnA.add("8E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("8E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8E_A.setForeground(Color.BLACK);
		btn8E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8E_A.setBackground(Color.LIGHT_GRAY);
		btn8E_A.setBounds(390, 425, 65, 32);
		AirbusA318SeatingPlan.add(btn8E_A);

		JToggleButton btn8F_A = new JToggleButton("8F");
		btn8F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn8F_A.isSelected()) {

						selectedSeatsDepartA.add("8F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("8F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn8F_A.isSelected()) {

						selectedSeatsReturnA.add("8F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("8F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8F_A.setForeground(Color.BLACK);
		btn8F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8F_A.setBackground(Color.LIGHT_GRAY);
		btn8F_A.setBounds(465, 425, 65, 30);
		AirbusA318SeatingPlan.add(btn8F_A);

		JToggleButton btn9A_A = new JToggleButton("9A");
		btn9A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn9A_A.isSelected()) {

						selectedSeatsDepartA.add("9A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("9A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn9A_A.isSelected()) {

						selectedSeatsReturnA.add("9A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("9A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9A_A.setForeground(Color.BLACK);
		btn9A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9A_A.setBackground(Color.LIGHT_GRAY);
		btn9A_A.setBounds(40, 465, 65, 30);
		AirbusA318SeatingPlan.add(btn9A_A);

		JToggleButton btn9B_A = new JToggleButton("9B");
		btn9B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn9B_A.isSelected()) {

						selectedSeatsDepartA.add("9B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("9B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn9B_A.isSelected()) {

						selectedSeatsReturnA.add("9B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("9B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9B_A.setForeground(Color.BLACK);
		btn9B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9B_A.setBackground(Color.LIGHT_GRAY);
		btn9B_A.setBounds(115, 465, 65, 30);
		AirbusA318SeatingPlan.add(btn9B_A);

		JToggleButton btn9C_A = new JToggleButton("9C");
		btn9C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn9C_A.isSelected()) {

						selectedSeatsDepartA.add("9C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("9C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn9C_A.isSelected()) {

						selectedSeatsReturnA.add("9C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("9C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9C_A.setForeground(Color.BLACK);
		btn9C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9C_A.setBackground(Color.LIGHT_GRAY);
		btn9C_A.setBounds(190, 465, 65, 30);
		AirbusA318SeatingPlan.add(btn9C_A);

		JToggleButton btn9D_A = new JToggleButton("9D");
		btn9D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn9D_A.isSelected()) {

						selectedSeatsDepartA.add("9D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("9D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn9D_A.isSelected()) {

						selectedSeatsReturnA.add("9D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("9D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9D_A.setForeground(Color.BLACK);
		btn9D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9D_A.setBackground(Color.LIGHT_GRAY);
		btn9D_A.setBounds(315, 465, 65, 30);
		AirbusA318SeatingPlan.add(btn9D_A);

		JToggleButton btn9E_A = new JToggleButton("9E");
		btn9E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn9E_A.isSelected()) {

						selectedSeatsDepartA.add("9E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("9E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn9E_A.isSelected()) {

						selectedSeatsReturnA.add("9E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("9E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9E_A.setForeground(Color.BLACK);
		btn9E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9E_A.setBackground(Color.LIGHT_GRAY);
		btn9E_A.setBounds(390, 465, 65, 30);
		AirbusA318SeatingPlan.add(btn9E_A);

		JToggleButton btn9F_A = new JToggleButton("9F");
		btn9F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn9F_A.isSelected()) {

						selectedSeatsDepartA.add("9F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("9F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn9F_A.isSelected()) {

						selectedSeatsReturnA.add("9F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("9F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9F_A.setForeground(Color.BLACK);
		btn9F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9F_A.setBackground(Color.LIGHT_GRAY);
		btn9F_A.setBounds(465, 465, 65, 30);
		AirbusA318SeatingPlan.add(btn9F_A);

		JToggleButton btn10A_A = new JToggleButton("10A");
		btn10A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn10A_A.isSelected()) {

						selectedSeatsDepartA.add("10A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("10A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn10A_A.isSelected()) {

						selectedSeatsReturnA.add("10A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("10A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10A_A.setForeground(Color.BLACK);
		btn10A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10A_A.setBackground(Color.LIGHT_GRAY);
		btn10A_A.setBounds(40, 505, 65, 30);
		AirbusA318SeatingPlan.add(btn10A_A);

		JButton btn10B_A = new JButton("10B");
		btn10B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				} else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btn10B_A.setForeground(Color.BLACK);
		btn10B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10B_A.setBackground(Color.RED);
		btn10B_A.setBounds(115, 505, 65, 30);
		AirbusA318SeatingPlan.add(btn10B_A);

		JToggleButton btn10C_A = new JToggleButton("10C");
		btn10C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn10C_A.isSelected()) {

						selectedSeatsDepartA.add("10C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("10C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn10C_A.isSelected()) {

						selectedSeatsReturnA.add("10C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("10C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10C_A.setForeground(Color.BLACK);
		btn10C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10C_A.setBackground(Color.LIGHT_GRAY);
		btn10C_A.setBounds(190, 505, 65, 30);
		AirbusA318SeatingPlan.add(btn10C_A);

		JToggleButton btn10D_A = new JToggleButton("10D");
		btn10D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn10D_A.isSelected()) {

						selectedSeatsDepartA.add("10D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("10D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn10D_A.isSelected()) {

						selectedSeatsReturnA.add("10D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("10D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10D_A.setForeground(Color.BLACK);
		btn10D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10D_A.setBackground(Color.LIGHT_GRAY);
		btn10D_A.setBounds(315, 505, 65, 30);
		AirbusA318SeatingPlan.add(btn10D_A);

		JToggleButton btn10E_A = new JToggleButton("10E");
		btn10E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn10E_A.isSelected()) {

						selectedSeatsDepartA.add("10E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("10E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn10E_A.isSelected()) {

						selectedSeatsReturnA.add("10E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("10E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10E_A.setForeground(Color.BLACK);
		btn10E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10E_A.setBackground(Color.LIGHT_GRAY);
		btn10E_A.setBounds(390, 505, 65, 30);
		AirbusA318SeatingPlan.add(btn10E_A);

		JToggleButton btn10F_A = new JToggleButton("10F");
		btn10F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn10F_A.isSelected()) {

						selectedSeatsDepartA.add("10F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("10F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn10F_A.isSelected()) {

						selectedSeatsReturnA.add("10F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("10F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10F_A.setForeground(Color.BLACK);
		btn10F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10F_A.setBackground(Color.LIGHT_GRAY);
		btn10F_A.setBounds(465, 505, 65, 30);
		AirbusA318SeatingPlan.add(btn10F_A);

		JToggleButton btn11A_A = new JToggleButton("11A");
		btn11A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn11A_A.isSelected()) {

						selectedSeatsDepartA.add("11A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("11A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn11A_A.isSelected()) {

						selectedSeatsReturnA.add("11A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("11A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11A_A.setForeground(Color.BLACK);
		btn11A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11A_A.setBackground(Color.LIGHT_GRAY);
		btn11A_A.setBounds(40, 545, 65, 30);
		AirbusA318SeatingPlan.add(btn11A_A);

		JToggleButton btn11B_A = new JToggleButton("11B");
		btn11B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn11B_A.isSelected()) {

						selectedSeatsDepartA.add("11B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("11B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn11B_A.isSelected()) {

						selectedSeatsReturnA.add("11B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("11B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11B_A.setForeground(Color.BLACK);
		btn11B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11B_A.setBackground(Color.LIGHT_GRAY);
		btn11B_A.setBounds(115, 545, 65, 30);
		AirbusA318SeatingPlan.add(btn11B_A);

		JToggleButton btn11C_A = new JToggleButton("11C");
		btn11C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn11C_A.isSelected()) {

						selectedSeatsDepartA.add("11C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("11C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn11C_A.isSelected()) {

						selectedSeatsReturnA.add("11C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("11C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11C_A.setForeground(Color.BLACK);
		btn11C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11C_A.setBackground(Color.LIGHT_GRAY);
		btn11C_A.setBounds(190, 545, 65, 30);
		AirbusA318SeatingPlan.add(btn11C_A);

		JToggleButton btn11D_A = new JToggleButton("11D");
		btn11D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn11D_A.isSelected()) {

						selectedSeatsDepartA.add("11D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("11D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn11D_A.isSelected()) {

						selectedSeatsReturnA.add("11D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("11D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11D_A.setForeground(Color.BLACK);
		btn11D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11D_A.setBackground(Color.LIGHT_GRAY);
		btn11D_A.setBounds(315, 545, 65, 30);
		AirbusA318SeatingPlan.add(btn11D_A);

		JToggleButton btn11E_A = new JToggleButton("11E");
		btn11E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn11E_A.isSelected()) {

						selectedSeatsDepartA.add("11E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("11E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn11E_A.isSelected()) {

						selectedSeatsReturnA.add("11E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("11E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11E_A.setForeground(Color.BLACK);
		btn11E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11E_A.setBackground(Color.LIGHT_GRAY);
		btn11E_A.setBounds(390, 545, 65, 30);
		AirbusA318SeatingPlan.add(btn11E_A);

		JToggleButton btn11F_A = new JToggleButton("11F");
		btn11F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn11F_A.isSelected()) {

						selectedSeatsDepartA.add("11F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("11F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn11F_A.isSelected()) {

						selectedSeatsReturnA.add("11F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("11F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11F_A.setForeground(Color.BLACK);
		btn11F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11F_A.setBackground(Color.LIGHT_GRAY);
		btn11F_A.setBounds(465, 545, 65, 30);
		AirbusA318SeatingPlan.add(btn11F_A);

		JToggleButton btn12A_A = new JToggleButton("12A");
		btn12A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn12A_A.isSelected()) {

						selectedSeatsDepartA.add("12A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("12A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn12A_A.isSelected()) {

						selectedSeatsReturnA.add("12A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("12A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12A_A.setForeground(Color.BLACK);
		btn12A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12A_A.setBackground(Color.LIGHT_GRAY);
		btn12A_A.setBounds(40, 585, 65, 30);
		AirbusA318SeatingPlan.add(btn12A_A);

		JToggleButton btn12B_A = new JToggleButton("12B");
		btn12B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn12B_A.isSelected()) {

						selectedSeatsDepartA.add("12B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("12B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn12B_A.isSelected()) {

						selectedSeatsReturnA.add("12B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("12B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12B_A.setForeground(Color.BLACK);
		btn12B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12B_A.setBackground(Color.LIGHT_GRAY);
		btn12B_A.setBounds(115, 585, 65, 30);
		AirbusA318SeatingPlan.add(btn12B_A);

		JToggleButton btn12C_A = new JToggleButton("12C");
		btn12C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn12C_A.isSelected()) {

						selectedSeatsDepartA.add("12C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("12C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn12C_A.isSelected()) {

						selectedSeatsReturnA.add("12C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("12C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12C_A.setForeground(Color.BLACK);
		btn12C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12C_A.setBackground(Color.LIGHT_GRAY);
		btn12C_A.setBounds(190, 585, 65, 30);
		AirbusA318SeatingPlan.add(btn12C_A);

		JToggleButton btn12D_A = new JToggleButton("12D");
		btn12D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn12D_A.isSelected()) {

						selectedSeatsDepartA.add("12D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("12D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn12D_A.isSelected()) {

						selectedSeatsReturnA.add("12D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("12D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12D_A.setForeground(Color.BLACK);
		btn12D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12D_A.setBackground(Color.LIGHT_GRAY);
		btn12D_A.setBounds(315, 585, 65, 30);
		AirbusA318SeatingPlan.add(btn12D_A);

		JToggleButton btn12E_A = new JToggleButton("12E");
		btn12E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn12E_A.isSelected()) {

						selectedSeatsDepartA.add("12E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("12E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn12E_A.isSelected()) {

						selectedSeatsReturnA.add("12E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("12E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12E_A.setForeground(Color.BLACK);
		btn12E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12E_A.setBackground(Color.LIGHT_GRAY);
		btn12E_A.setBounds(390, 585, 65, 30);
		AirbusA318SeatingPlan.add(btn12E_A);

		JToggleButton btn12F_A = new JToggleButton("12F");
		btn12F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn12F_A.isSelected()) {

						selectedSeatsDepartA.add("12F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("12F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn12F_A.isSelected()) {

						selectedSeatsReturnA.add("12F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("12F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12F_A.setForeground(Color.BLACK);
		btn12F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12F_A.setBackground(Color.LIGHT_GRAY);
		btn12F_A.setBounds(465, 585, 65, 30);
		AirbusA318SeatingPlan.add(btn12F_A);

		JToggleButton btn13A_A = new JToggleButton("13A");
		btn13A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn13A_A.isSelected()) {

						selectedSeatsDepartA.add("13A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("13A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn13A_A.isSelected()) {

						selectedSeatsReturnA.add("13A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("13A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13A_A.setForeground(Color.BLACK);
		btn13A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13A_A.setBackground(Color.LIGHT_GRAY);
		btn13A_A.setBounds(40, 625, 65, 30);
		AirbusA318SeatingPlan.add(btn13A_A);

		JToggleButton btn13B_A = new JToggleButton("13B");
		btn13B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn13B_A.isSelected()) {

						selectedSeatsDepartA.add("13B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("13B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn13B_A.isSelected()) {

						selectedSeatsReturnA.add("13B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("13B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13B_A.setForeground(Color.BLACK);
		btn13B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13B_A.setBackground(Color.LIGHT_GRAY);
		btn13B_A.setBounds(115, 625, 65, 30);
		AirbusA318SeatingPlan.add(btn13B_A);

		JToggleButton btn13C_A = new JToggleButton("13C");
		btn13C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn13C_A.isSelected()) {

						selectedSeatsDepartA.add("13C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("13C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn13C_A.isSelected()) {

						selectedSeatsReturnA.add("13C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("13C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13C_A.setForeground(Color.BLACK);
		btn13C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13C_A.setBackground(Color.LIGHT_GRAY);
		btn13C_A.setBounds(190, 625, 65, 30);
		AirbusA318SeatingPlan.add(btn13C_A);

		JToggleButton btn13D_A = new JToggleButton("13D");
		btn13D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn13D_A.isSelected()) {

						selectedSeatsDepartA.add("13D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("13D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn13D_A.isSelected()) {

						selectedSeatsReturnA.add("13D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("13D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13D_A.setForeground(Color.BLACK);
		btn13D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13D_A.setBackground(Color.LIGHT_GRAY);
		btn13D_A.setBounds(315, 625, 65, 30);
		AirbusA318SeatingPlan.add(btn13D_A);

		JButton btn13E_A = new JButton("13E");
		btn13E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);
				}

				else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btn13E_A.setForeground(Color.BLACK);
		btn13E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13E_A.setBackground(Color.RED);
		btn13E_A.setBounds(390, 625, 65, 30);
		AirbusA318SeatingPlan.add(btn13E_A);

		JToggleButton btn13F_A = new JToggleButton("13F");
		btn13F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn13F_A.isSelected()) {

						selectedSeatsDepartA.add("13F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("13F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn13F_A.isSelected()) {

						selectedSeatsReturnA.add("13F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("13F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13F_A.setForeground(Color.BLACK);
		btn13F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13F_A.setBackground(Color.LIGHT_GRAY);
		btn13F_A.setBounds(465, 625, 65, 30);
		AirbusA318SeatingPlan.add(btn13F_A);

		JToggleButton btn14A_A = new JToggleButton("14A");
		btn14A_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn14A_A.isSelected()) {

						selectedSeatsDepartA.add("14A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("14A");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn14A_A.isSelected()) {

						selectedSeatsReturnA.add("14A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("14A");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14A_A.setForeground(Color.BLACK);
		btn14A_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14A_A.setBackground(Color.LIGHT_GRAY);
		btn14A_A.setBounds(40, 665, 65, 30);
		AirbusA318SeatingPlan.add(btn14A_A);

		JToggleButton btn14B_A = new JToggleButton("14B");
		btn14B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn2B_A.isSelected()) {

						selectedSeatsDepartA.add("2B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("2B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn2B_A.isSelected()) {

						selectedSeatsReturnA.add("2B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("2B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14B_A.setForeground(Color.BLACK);
		btn14B_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14B_A.setBackground(Color.LIGHT_GRAY);
		btn14B_A.setBounds(115, 665, 65, 30);
		AirbusA318SeatingPlan.add(btn14B_A);

		JToggleButton btn14C_A = new JToggleButton("14C");
		btn14C_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn14C_A.isSelected()) {

						selectedSeatsDepartA.add("14C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("14C");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn14C_A.isSelected()) {

						selectedSeatsReturnA.add("14C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("14C");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14C_A.setForeground(Color.BLACK);
		btn14C_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14C_A.setBackground(Color.LIGHT_GRAY);
		btn14C_A.setBounds(190, 665, 65, 30);
		AirbusA318SeatingPlan.add(btn14C_A);

		JToggleButton btn14D_A = new JToggleButton("14D");
		btn14D_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn14D_A.isSelected()) {

						selectedSeatsDepartA.add("14D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("14D");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn14D_A.isSelected()) {

						selectedSeatsReturnA.add("14D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("14D");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14D_A.setForeground(Color.BLACK);
		btn14D_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14D_A.setBackground(Color.LIGHT_GRAY);
		btn14D_A.setBounds(315, 665, 65, 30);
		AirbusA318SeatingPlan.add(btn14D_A);

		JToggleButton btn14E_A = new JToggleButton("14E");
		btn14E_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn14E_A.isSelected()) {

						selectedSeatsDepartA.add("14E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("14E");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn14E_A.isSelected()) {

						selectedSeatsReturnA.add("14E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("14E");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14E_A.setForeground(Color.BLACK);
		btn14E_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14E_A.setBackground(Color.LIGHT_GRAY);
		btn14E_A.setBounds(390, 665, 65, 30);
		AirbusA318SeatingPlan.add(btn14E_A);

		JToggleButton btn14F_A = new JToggleButton("14F");
		btn14F_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					if (btn14F_A.isSelected()) {

						selectedSeatsDepartA.add("14F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("14F");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn14F_A.isSelected()) {

						selectedSeatsReturnA.add("14F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("14F");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

				}

			}
		});
		btn14F_A.setForeground(Color.BLACK);
		btn14F_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14F_A.setBackground(Color.LIGHT_GRAY);
		btn14F_A.setBounds(465, 665, 65, 30);
		AirbusA318SeatingPlan.add(btn14F_A);

		btnContinue_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {
					if (selectedSeatsDepartA.size() != ticketAmount_D) {
						JOptionPane.showMessageDialog(frame, "Amount of seats chosen to Tickets selected are not equal",
								"You must select the same amount of seatsto the tickets selected",
								JOptionPane.ERROR_MESSAGE);
					}

					else if (selectedSeatsDepartA.isEmpty()) {

						JOptionPane.showMessageDialog(frame, "A seat Hasn't been chosen",
								"A seat Must be Chosen before continuing ", JOptionPane.ERROR_MESSAGE);

					}

					else {
						loopSeatingPlan += 1;

						AirbusA318SeatingPlan.show();
						lblDepartureFlightSeats_A.hide();
						lblReturnFlightSeats_A.show();
						plBack.hide();
						TxtFTicketAmount_D.setText(
								ticketAmounts = Integer.toString(ticketAmount_R).replace('[', ' ').replace(']', ' '));
						JOptionPane.showMessageDialog(frame, "You must reselect the seats you want for return");
					}

				}

				else {
					if (selectedSeatsReturnA.size() != ticketAmount_R) {
						JOptionPane.showMessageDialog(frame, "Amount of seats chosen to Tickets selected are not equal",
								"You must select the same amount of seatsto the tickets selected",
								JOptionPane.ERROR_MESSAGE);
					}

					else if (selectedSeatsReturnA.isEmpty()) {

						JOptionPane.showMessageDialog(frame, "A seat Hasn't been chosen",
								"A seat Must be Chosen before continuing ", JOptionPane.ERROR_MESSAGE);

					}

					else {
						AirbusA318SeatingPlan.hide();
						lblDepartureFlightSeats_A.hide();
						lblReturnFlightSeats_A.hide();
						plBack.show();

					}

				}
			}
		});
		btnContinue_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinue_A.setBounds(375, 876, 155, 48);
		AirbusA318SeatingPlan.add(btnContinue_A);

		// }
		// AIRBUS SEATING PLAN - end

		// BOEING SEATING PLAN - start
		// {
		JPanel Boeing747SeatingPlan = new JPanel();
		Boeing747SeatingPlan.setForeground(Color.BLACK);
		Boeing747SeatingPlan.setBorder(new LineBorder(Color.BLACK, 2));
		Boeing747SeatingPlan.setBackground(Color.WHITE);
		Boeing747SeatingPlan.setBounds(0, 0, 547, 955);
		frame.getContentPane().add(Boeing747SeatingPlan);
		// JScrollBar scrollBar = new JScrollPane(Boeing747SeatingPlan,
		// JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// JScrollPane scrollPane = new JScrollPane(Boeing747SeatingPlan,
		// JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane.setBounds(579, 151, 2, 2);
		// frame.getContentPane().add(scrollPane);

		JLabel lblDepartureFlightSeats_B = new JLabel("Departure Flight Seats");
		lblDepartureFlightSeats_B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepartureFlightSeats_B.setBounds(171, 71, 205, 55);
		Boeing747SeatingPlan.add(lblDepartureFlightSeats_B);

		JLabel lblReturnFlightSeats_B = new JLabel("Return Flight Seats");
		lblReturnFlightSeats_B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReturnFlightSeats_B.setBounds(171, 71, 205, 55);
		Boeing747SeatingPlan.add(lblReturnFlightSeats_B);

		JButton btnBack_B = new JButton("Back");

		JButton btnContinue_B = new JButton("Continue");

		JTextPane txtLBoeing747 = new JTextPane();
		txtLBoeing747.setBounds(149, 28, 246, 32);
		txtLBoeing747.setText("         Boeing747");
		txtLBoeing747.setForeground(Color.BLACK);
		txtLBoeing747.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtLBoeing747.setEditable(false);
		txtLBoeing747.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(txtLBoeing747);

		JLabel lblFirstClass = new JLabel("First Class");
		lblFirstClass.setBounds(25, 55, 111, 25);
		lblFirstClass.setForeground(Color.BLACK);
		lblFirstClass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstClass.setEnabled(false);
		lblFirstClass.setBackground(Color.BLACK);
		Boeing747SeatingPlan.add(lblFirstClass);

		JToggleButton btn1A_B = new JToggleButton("1A");
		btn1A_B.setBounds(40, 83, 65, 30);
		btn1A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* if btn1 is pressed for boeing747 then the actions bellow would occur */

				if (loopSeatingPlan == 0) {
					/* this will detect whether the user is on the departures page or return page */
					if (btn1A_B.isSelected()) { /* if the button is selected */

						selectedSeatsDepartB.add("1A");
						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else { /* if the button is unselected */
						/* removes the the string "1B" from the array list */
						selectedSeatsDepartB.remove("1A");
						/*
						 * displays the array list containing the selected seats for boeing747 departure
						 * displayed within a text field
						 */
						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {
					/*
					 * this executables bellow are used for the return page of boeing747 seating
					 * Plan
					 */

					if (btn1A_B.isSelected()) { /* if the button is selected */

						selectedSeatsReturnB.add("1A");
						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {/* if the button is unselected */
						selectedSeatsReturnB.remove("1A");
						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn1A_B.setForeground(Color.BLACK);
		btn1A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn1A_B);

		JToggleButton btn1B_B = new JToggleButton("1B");
		btn1B_B.setBounds(465, 80, 65, 30);
		btn1B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loopSeatingPlan == 0) {

					if (btn1B_B.isSelected()) {

						selectedSeatsDepartA.add("1B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartA.remove("1B");

						txtFDepartSeats.setText(selectedSeatsDepartA.toString().replace('[', ' ').replace(']', ' '));
					}

				} else {

					if (btn1B_B.isSelected()) {

						selectedSeatsReturnA.add("1B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnA.remove("1B");

						txtFReturnSeats.setText(selectedSeatsReturnA.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn1B_B.setForeground(Color.BLACK);
		btn1B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn1B_B);

		JToggleButton btn2A_B = new JToggleButton("2A");
		btn2A_B.setBounds(40, 123, 65, 30);
		btn2A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn1A_B.isSelected()) {

						selectedSeatsDepartB.add("2A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("2A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn1A_B.isSelected()) {

						selectedSeatsReturnB.add("2A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("2A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn2A_B.setForeground(Color.BLACK);
		btn2A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn2A_B);

		JToggleButton btn2B_B = new JToggleButton("2B");
		btn2B_B.setBounds(465, 123, 65, 30);
		btn2B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn2B_B.isSelected()) {

						selectedSeatsDepartB.add("2B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("2B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn2B_B.isSelected()) {

						selectedSeatsReturnB.add("2B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("2B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn2B_B.setForeground(Color.BLACK);
		btn2B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn2B_B);

		JToggleButton btn3A_B = new JToggleButton("3A");
		btn3A_B.setBounds(40, 163, 65, 30);
		btn3A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn3A_B.isSelected()) {

						selectedSeatsDepartB.add("3A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("3A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn3A_B.isSelected()) {

						selectedSeatsReturnB.add("3A");
						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("3A");
						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn3A_B.setForeground(Color.BLACK);
		btn3A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn3A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn3A_B);

		JToggleButton btn3B_B = new JToggleButton("3B");
		btn3B_B.setBounds(465, 168, 65, 30);
		btn3B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn3B_B.isSelected()) {
						selectedSeatsDepartB.add("3B");
						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("3B");
						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn3B_B.isSelected()) {
						selectedSeatsReturnB.add("3A");
						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("3A");
						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn3B_B.setForeground(Color.BLACK);
		btn3B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn3B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn3B_B);

		JToggleButton btn4A_B = new JToggleButton("4A");
		btn4A_B.setBounds(40, 203, 65, 30);
		btn4A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn1A_B.isSelected()) {

						selectedSeatsDepartB.add("4A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("4A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn1A_B.isSelected()) {

						selectedSeatsReturnB.add("4A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("4A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn4A_B.setForeground(Color.BLACK);
		btn4A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn4A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn4A_B);

		JToggleButton btn4B_B = new JToggleButton("4B");
		btn4B_B.setBounds(465, 211, 65, 30);
		btn4B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn4B_B.isSelected()) {

						selectedSeatsDepartB.add("4B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("4B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn4B_B.isSelected()) {

						selectedSeatsReturnB.add("4B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("4B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});

		btn4B_B.setForeground(Color.BLACK);
		btn4B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn4B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn4B_B);

		JToggleButton btn5B_B = new JToggleButton("5B");
		btn5B_B.setBounds(465, 254, 65, 30);
		btn5B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn5B_B.isSelected()) {

						selectedSeatsDepartB.add("5B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("5B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn5B_B.isSelected()) {

						selectedSeatsReturnB.add("5B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("5B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn5B_B.setForeground(Color.BLACK);
		btn5B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5B_B.setBackground(Color.LIGHT_GRAY);

		JToggleButton btn5A_B = new JToggleButton("5A");
		btn5A_B.setBounds(40, 243, 65, 30);
		btn5A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn5A_B.isSelected()) {

						selectedSeatsDepartB.add("5A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("5A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn5A_B.isSelected()) {

						selectedSeatsReturnB.add("5A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("5A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn5A_B.setForeground(Color.BLACK);
		btn5A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn5A_B);
		Boeing747SeatingPlan.add(btn5B_B);

		JLabel lblEconomy_B = new JLabel("Economy");
		lblEconomy_B.setBounds(25, 503, 100, 25);
		lblEconomy_B.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEconomy_B.setEnabled(false);
		lblEconomy_B.setBackground(Color.BLACK);
		Boeing747SeatingPlan.add(lblEconomy_B);

		JToggleButton btn6A_B = new JToggleButton("6A");
		btn6A_B.setBounds(40, 312, 65, 30);
		btn6A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn6A_B.isSelected()) {

						selectedSeatsDepartB.add("6A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("6A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn6A_B.isSelected()) {

						selectedSeatsReturnB.add("6A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("6A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6A_B.setForeground(Color.BLACK);
		btn6A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn6A_B);

		JToggleButton btn6B_B = new JToggleButton("6B");
		btn6B_B.setBounds(190, 312, 65, 30);
		btn6B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn6B_B.isSelected()) {

						selectedSeatsDepartB.add("6B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("6B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn6B_B.isSelected()) {

						selectedSeatsReturnB.add("6B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("6B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6B_B.setForeground(Color.BLACK);
		btn6B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn6B_B);

		JButton btn6C_B = new JButton("6C");
		btn6C_B.setBounds(315, 312, 65, 30);
		btn6C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);
				}

				else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		btn6C_B.setForeground(Color.BLACK);
		btn6C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6C_B.setBackground(Color.RED);
		Boeing747SeatingPlan.add(btn6C_B);

		JToggleButton btn6D_B = new JToggleButton("6D");
		btn6D_B.setBounds(465, 312, 65, 30);
		btn6D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn6D_B.isSelected()) {

						selectedSeatsDepartB.add("6D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("6D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn6D_B.isSelected()) {

						selectedSeatsReturnB.add("6D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("6D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn6D_B.setForeground(Color.BLACK);
		btn6D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn6D_B);

		JToggleButton btn7A_B = new JToggleButton("7A");
		btn7A_B.setBounds(40, 352, 65, 30);
		btn7A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn7A_B.isSelected()) {

						selectedSeatsDepartB.add("7A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("7A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn7A_B.isSelected()) {

						selectedSeatsReturnB.add("7A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("7A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7A_B.setForeground(Color.BLACK);
		btn7A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn7A_B);

		JToggleButton btn7B_B = new JToggleButton("7B");
		btn7B_B.setBounds(190, 352, 65, 30);
		btn7B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn7B_B.isSelected()) {

						selectedSeatsDepartB.add("7B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("7B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn7B_B.isSelected()) {

						selectedSeatsReturnB.add("7B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("7B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7B_B.setForeground(Color.BLACK);
		btn7B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn7B_B);

		JToggleButton btn7C_B = new JToggleButton("7C");
		btn7C_B.setBounds(315, 352, 65, 32);
		btn7C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn7C_B.isSelected()) {

						selectedSeatsDepartB.add("7C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("7C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn7C_B.isSelected()) {

						selectedSeatsReturnB.add("7C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("7C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7C_B.setForeground(Color.BLACK);
		btn7C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn7C_B);

		JToggleButton btn7D_B = new JToggleButton("7D");
		btn7D_B.setBounds(465, 352, 65, 30);
		btn7D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn7D_B.isSelected()) {

						selectedSeatsDepartB.add("7D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("7D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn7D_B.isSelected()) {

						selectedSeatsReturnB.add("7D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("7D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn7D_B.setForeground(Color.BLACK);
		btn7D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn7D_B);

		JToggleButton btn8A_B = new JToggleButton("8A");
		btn8A_B.setBounds(40, 392, 65, 30);
		btn8A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn8A_B.isSelected()) {

						selectedSeatsDepartB.add("8A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("8A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn8A_B.isSelected()) {

						selectedSeatsReturnB.add("8A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("8A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8A_B.setForeground(Color.BLACK);
		btn8A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn8A_B);

		JToggleButton btn8B_B = new JToggleButton("8B");
		btn8B_B.setBounds(190, 392, 65, 32);
		btn8B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn8B_B.isSelected()) {

						selectedSeatsDepartB.add("8B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("8B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn8B_B.isSelected()) {

						selectedSeatsReturnB.add("8B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("8B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8B_B.setForeground(Color.BLACK);
		btn8B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn8B_B);

		JToggleButton btn8C_B = new JToggleButton("8C");
		btn8C_B.setBounds(315, 392, 65, 30);
		btn8C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn8C_B.isSelected()) {

						selectedSeatsDepartB.add("8C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("8C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn8C_B.isSelected()) {

						selectedSeatsReturnB.add("8C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("8C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8C_B.setForeground(Color.BLACK);
		btn8C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn8C_B);

		JToggleButton btn8D_B = new JToggleButton("8D");
		btn8D_B.setBounds(465, 392, 65, 30);
		btn8D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn8D_B.isSelected()) {

						selectedSeatsDepartB.add("8D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("8D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn8D_B.isSelected()) {

						selectedSeatsReturnB.add("8D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("8D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn8D_B.setForeground(Color.BLACK);
		btn8D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn8D_B);

		JToggleButton btn9A_B = new JToggleButton("9A");
		btn9A_B.setBounds(40, 432, 65, 30);
		btn9A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn9A_B.isSelected()) {

						selectedSeatsDepartB.add("9A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("9A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn9A_B.isSelected()) {

						selectedSeatsReturnB.add("9A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("9A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9A_B.setForeground(Color.BLACK);
		btn9A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn9A_B);

		JToggleButton btn9B_B = new JToggleButton("9B");
		btn9B_B.setBounds(190, 432, 65, 30);
		btn9B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn9B_B.isSelected()) {

						selectedSeatsDepartB.add("9B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("9B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn9B_B.isSelected()) {

						selectedSeatsReturnB.add("9B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("9B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9B_B.setForeground(Color.BLACK);
		btn9B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn9B_B);

		JToggleButton btn9C_B = new JToggleButton("9C");
		btn9C_B.setBounds(315, 432, 65, 30);
		btn9C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn9C_B.isSelected()) {

						selectedSeatsDepartB.add("9C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("9C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn9C_B.isSelected()) {

						selectedSeatsReturnB.add("9C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("9C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9C_B.setForeground(Color.BLACK);
		btn9C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn9C_B);

		JToggleButton btn9D_B = new JToggleButton("9D");
		btn9D_B.setBounds(465, 432, 65, 30);
		btn9D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn9D_B.isSelected()) {

						selectedSeatsDepartB.add("9D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("9D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn9D_B.isSelected()) {

						selectedSeatsReturnB.add("9D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("9D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn9D_B.setForeground(Color.BLACK);
		btn9D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn9D_B);

		JToggleButton btn10A_B = new JToggleButton("10A");
		btn10A_B.setBounds(40, 472, 65, 30);
		btn10A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn10A_B.isSelected()) {

						selectedSeatsDepartB.add("10A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("10A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn10A_B.isSelected()) {

						selectedSeatsReturnB.add("10A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("10A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10A_B.setForeground(Color.BLACK);
		btn10A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn10A_B);

		JToggleButton btn10B_B = new JToggleButton("10B");
		btn10B_B.setBounds(190, 472, 65, 30);
		btn10B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn10B_B.isSelected()) {

						selectedSeatsDepartB.add("10B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("10B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn10B_B.isSelected()) {

						selectedSeatsReturnB.add("10B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("10B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10B_B.setForeground(Color.BLACK);
		btn10B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn10B_B);

		JToggleButton btn10C_B = new JToggleButton("10C");
		btn10C_B.setBounds(315, 472, 65, 30);
		btn10C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn10C_B.isSelected()) {

						selectedSeatsDepartB.add("10C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("10C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn10C_B.isSelected()) {

						selectedSeatsReturnB.add("10C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("10C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10C_B.setForeground(Color.BLACK);
		btn10C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn10C_B);

		JToggleButton btn10D_B = new JToggleButton("10D");
		btn10D_B.setBounds(465, 472, 65, 30);
		btn10D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn10D_B.isSelected()) {

						selectedSeatsDepartB.add("10D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("10D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn10D_B.isSelected()) {

						selectedSeatsReturnB.add("10D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("10D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn10D_B.setForeground(Color.BLACK);
		btn10D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn10D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn10D_B);

		JToggleButton btn11A_B = new JToggleButton("11A");
		btn11A_B.setBounds(40, 529, 65, 30);
		btn11A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn11A_B.isSelected()) {

						selectedSeatsDepartB.add("11A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("11A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn11A_B.isSelected()) {

						selectedSeatsReturnB.add("11A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("11A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11A_B.setForeground(Color.BLACK);
		btn11A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn11A_B);

		JToggleButton btn11B_B = new JToggleButton("11B");
		btn11B_B.setBounds(115, 529, 65, 30);
		btn11B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn11B_B.isSelected()) {

						selectedSeatsDepartB.add("11B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("11B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn11B_B.isSelected()) {

						selectedSeatsReturnB.add("11B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("11B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11B_B.setForeground(Color.BLACK);
		btn11B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn11B_B);

		JToggleButton btn11C_B = new JToggleButton("11C");
		btn11C_B.setBounds(190, 529, 65, 30);
		btn11C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn11C_B.isSelected()) {

						selectedSeatsDepartB.add("11C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("11C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn11C_B.isSelected()) {

						selectedSeatsReturnB.add("11C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("11C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11C_B.setForeground(Color.BLACK);
		btn11C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn11C_B);

		JToggleButton btn11D_B = new JToggleButton("11D");
		btn11D_B.setBounds(315, 529, 65, 30);
		btn11D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn11D_B.isSelected()) {

						selectedSeatsDepartB.add("11D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("11D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn11D_B.isSelected()) {

						selectedSeatsReturnB.add("11D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("11D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11D_B.setForeground(Color.BLACK);
		btn11D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn11D_B);

		JToggleButton btn11E_B = new JToggleButton("11E");
		btn11E_B.setBounds(390, 529, 65, 30);
		btn11E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn11E_B.isSelected()) {

						selectedSeatsDepartB.add("11E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("11E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn11E_B.isSelected()) {

						selectedSeatsReturnB.add("11E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("11E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11E_B.setForeground(Color.BLACK);
		btn11E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn11E_B);

		JToggleButton btn11F_B = new JToggleButton("11F");
		btn11F_B.setBounds(465, 529, 65, 30);
		btn11F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn11F_B.isSelected()) {

						selectedSeatsDepartB.add("11F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("11F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn11F_B.isSelected()) {

						selectedSeatsReturnB.add("11F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("11F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn11F_B.setForeground(Color.BLACK);
		btn11F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn11F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn11F_B);

		JToggleButton btn12A_B = new JToggleButton("12A");
		btn12A_B.setBounds(40, 569, 65, 30);
		btn12A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn12A_B.isSelected()) {

						selectedSeatsDepartB.add("12A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("12A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn12A_B.isSelected()) {

						selectedSeatsReturnB.add("12A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("12A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12A_B.setForeground(Color.BLACK);
		btn12A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn12A_B);

		JToggleButton btn12B_B = new JToggleButton("12B");
		btn12B_B.setBounds(115, 569, 65, 30);
		btn12B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn12B_B.isSelected()) {

						selectedSeatsDepartB.add("12B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("12B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn12B_B.isSelected()) {

						selectedSeatsReturnB.add("12B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("12B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12B_B.setForeground(Color.BLACK);
		btn12B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn12B_B);

		JToggleButton btn12C_B = new JToggleButton("12C");
		btn12C_B.setBounds(190, 569, 65, 30);
		btn12C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn12C_B.isSelected()) {

						selectedSeatsDepartB.add("12C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("12C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn12C_B.isSelected()) {

						selectedSeatsReturnB.add("12C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("12C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12C_B.setForeground(Color.BLACK);
		btn12C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn12C_B);

		JToggleButton btn12D_B = new JToggleButton("12D");
		btn12D_B.setBounds(315, 569, 65, 30);
		btn12D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn12D_B.isSelected()) {

						selectedSeatsDepartB.add("12D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("12D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn12D_B.isSelected()) {

						selectedSeatsReturnB.add("12D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("12D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12D_B.setForeground(Color.BLACK);
		btn12D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn12D_B);

		JToggleButton btn12E_B = new JToggleButton("12E");
		btn12E_B.setBounds(390, 569, 65, 30);
		btn12E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn12E_B.isSelected()) {

						selectedSeatsDepartB.add("12E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("12E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn12E_B.isSelected()) {

						selectedSeatsReturnB.add("12E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("12E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12E_B.setForeground(Color.BLACK);
		btn12E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn12E_B);

		JToggleButton btn12F_B = new JToggleButton("12F");
		btn12F_B.setBounds(465, 569, 65, 30);
		btn12F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn12F_B.isSelected()) {

						selectedSeatsDepartB.add("12F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("12F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn12F_B.isSelected()) {

						selectedSeatsReturnB.add("12F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("12F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn12F_B.setForeground(Color.BLACK);
		btn12F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn12F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn12F_B);

		JToggleButton btn13A_B = new JToggleButton("13A");
		btn13A_B.setBounds(40, 609, 65, 30);
		btn13A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn13A_B.isSelected()) {

						selectedSeatsDepartB.add("13A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("13A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn13A_B.isSelected()) {

						selectedSeatsReturnB.add("13A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("13A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13A_B.setForeground(Color.BLACK);
		btn13A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn13A_B);

		JToggleButton btn13B_B = new JToggleButton("13B");
		btn13B_B.setBounds(115, 609, 65, 30);
		btn13B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn13B_B.isSelected()) {

						selectedSeatsDepartB.add("13B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("13B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn13B_B.isSelected()) {

						selectedSeatsReturnB.add("13B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("13B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13B_B.setForeground(Color.BLACK);
		btn13B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn13B_B);

		JToggleButton btn13C_B = new JToggleButton("13C");
		btn13C_B.setBounds(190, 609, 65, 30);
		btn13C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn13C_B.isSelected()) {

						selectedSeatsDepartB.add("13C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("13C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn13C_B.isSelected()) {

						selectedSeatsReturnB.add("13C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("13C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13C_B.setForeground(Color.BLACK);
		btn13C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn13C_B);

		JToggleButton btn13D_B = new JToggleButton("13D");
		btn13D_B.setBounds(315, 609, 65, 30);
		btn13D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn13D_B.isSelected()) {

						selectedSeatsDepartB.add("13D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("13D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn13D_B.isSelected()) {

						selectedSeatsReturnB.add("13D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("13D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13D_B.setForeground(Color.BLACK);
		btn13D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn13D_B);

		JToggleButton btn13E_B = new JToggleButton("13E");
		btn13E_B.setBounds(390, 609, 65, 30);
		btn13E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn13E_B.isSelected()) {

						selectedSeatsDepartB.add("13E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("13E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn13E_B.isSelected()) {

						selectedSeatsReturnB.add("13E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("13E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13E_B.setForeground(Color.BLACK);
		btn13E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn13E_B);

		JToggleButton btn13F_B = new JToggleButton("13F");
		btn13F_B.setBounds(465, 609, 65, 30);
		btn13F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn13F_B.isSelected()) {

						selectedSeatsDepartB.add("13F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("13F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn13F_B.isSelected()) {

						selectedSeatsReturnB.add("13F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("13F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn13F_B.setForeground(Color.BLACK);
		btn13F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn13F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn13F_B);

		JToggleButton btn14A_B = new JToggleButton("14A");
		btn14A_B.setBounds(40, 649, 65, 30);
		btn14A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn14A_B.isSelected()) {

						selectedSeatsDepartB.add("14A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("14A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn14A_B.isSelected()) {

						selectedSeatsReturnB.add("14A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("14A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14A_B.setForeground(Color.BLACK);
		btn14A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn14A_B);

		JToggleButton btn14B_B = new JToggleButton("14B");
		btn14B_B.setBounds(115, 649, 65, 30);
		btn14B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn14B_B.isSelected()) {

						selectedSeatsDepartB.add("14B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("14B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn14B_B.isSelected()) {

						selectedSeatsReturnB.add("14B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("14B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14B_B.setForeground(Color.BLACK);
		btn14B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn14B_B);

		JToggleButton btn14C_B = new JToggleButton("14C");
		btn14C_B.setBounds(190, 649, 65, 30);
		btn14C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn14C_B.isSelected()) {

						selectedSeatsDepartB.add("14C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("14C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn14C_B.isSelected()) {

						selectedSeatsReturnB.add("14C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("14C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn14C_B.setForeground(Color.BLACK);
		btn14C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn14C_B);

		JToggleButton btn14D_B = new JToggleButton("14D");
		btn14D_B.setBounds(315, 649, 65, 30);
		btn14D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn14D_B.isSelected()) {

						selectedSeatsDepartB.add("14D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("14D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn14D_B.isSelected()) {

						selectedSeatsReturnB.add("14D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("14D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14D_B.setForeground(Color.BLACK);
		btn14D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn14D_B);

		JToggleButton btn14E_B = new JToggleButton("14E");
		btn14E_B.setBounds(390, 649, 65, 30);
		btn14E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn14E_B.isSelected()) {

						selectedSeatsDepartB.add("14E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("14E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn14E_B.isSelected()) {

						selectedSeatsReturnB.add("14E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("14E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14E_B.setForeground(Color.BLACK);
		btn14E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn14E_B);

		JToggleButton btn14F_B = new JToggleButton("14F");
		btn14F_B.setBounds(465, 649, 65, 30);
		btn14F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn14F_B.isSelected()) {

						selectedSeatsDepartB.add("14F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("14F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn14F_B.isSelected()) {

						selectedSeatsReturnB.add("14F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("14F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn14F_B.setForeground(Color.BLACK);
		btn14F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn14F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn14F_B);

		JLabel lblBusinessClass_B = new JLabel("Business Class");
		lblBusinessClass_B.setBounds(25, 280, 126, 25);
		lblBusinessClass_B.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBusinessClass_B.setEnabled(false);
		lblBusinessClass_B.setBackground(Color.BLACK);
		Boeing747SeatingPlan.add(lblBusinessClass_B);

		JToggleButton btn15A_B = new JToggleButton("15A");
		btn15A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn15A_B.isSelected()) {

						selectedSeatsDepartB.add("15A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("15A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn15A_B.isSelected()) {

						selectedSeatsReturnB.add("15A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("15A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn15A_B.setBounds(40, 689, 65, 30);
		btn15A_B.setForeground(Color.BLACK);
		btn15A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn15A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn15A_B);

		JToggleButton btn15B_B = new JToggleButton("15B");
		btn15B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn15B_B.isSelected()) {

						selectedSeatsDepartB.add("15B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("15B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn15B_B.isSelected()) {

						selectedSeatsReturnB.add("15B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("15B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn15B_B.setBounds(115, 689, 65, 30);
		btn15B_B.setForeground(Color.BLACK);
		btn15B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn15B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn15B_B);

		JToggleButton btn15C_B = new JToggleButton("15C");
		btn15C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn15C_B.isSelected()) {

						selectedSeatsDepartB.add("15C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("15C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn15C_B.isSelected()) {

						selectedSeatsReturnB.add("15C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("15C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn15C_B.setBounds(190, 689, 65, 30);
		btn15C_B.setForeground(Color.BLACK);
		btn15C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn15C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn15C_B);

		JToggleButton btn15D_B = new JToggleButton("15D");
		btn15D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn15D_B.isSelected()) {

						selectedSeatsDepartB.add("15D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("15D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn15D_B.isSelected()) {

						selectedSeatsReturnB.add("15D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("15D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn15D_B.setBounds(315, 689, 65, 30);
		btn15D_B.setForeground(Color.BLACK);
		btn15D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn15D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn15D_B);

		JToggleButton btn15E_B = new JToggleButton("15E");
		btn15E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn15E_B.isSelected()) {

						selectedSeatsDepartB.add("15E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("15E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn15E_B.isSelected()) {

						selectedSeatsReturnB.add("15E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("15E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn15E_B.setBounds(390, 689, 65, 30);
		btn15E_B.setForeground(Color.BLACK);
		btn15E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn15E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn15E_B);

		JToggleButton btn15F_B = new JToggleButton("15F");
		btn15F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn15F_B.isSelected()) {

						selectedSeatsDepartB.add("15F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("15F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn15F_B.isSelected()) {

						selectedSeatsReturnB.add("15F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("15F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn15F_B.setBounds(465, 689, 65, 30);
		btn15F_B.setForeground(Color.BLACK);
		btn15F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn15F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn15F_B);

		JToggleButton btn16F_B = new JToggleButton("16F");
		btn16F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn16F_B.isSelected()) {

						selectedSeatsDepartB.add("16F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("16F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn16F_B.isSelected()) {

						selectedSeatsReturnB.add("16F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("16F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn16F_B.setBounds(465, 729, 65, 30);
		btn16F_B.setForeground(Color.BLACK);
		btn16F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn16F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn16F_B);

		JToggleButton btn16E_B = new JToggleButton("16E");
		btn16E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn16F_B.isSelected()) {

						selectedSeatsDepartB.add("16F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("16F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn16F_B.isSelected()) {

						selectedSeatsReturnB.add("16F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("16F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn16E_B.setBounds(390, 729, 65, 30);
		btn16E_B.setForeground(Color.BLACK);
		btn16E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn16E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn16E_B);

		JToggleButton btn16D_B = new JToggleButton("16D");
		btn16D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn16D_B.isSelected()) {

						selectedSeatsDepartB.add("16D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("16D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn16D_B.isSelected()) {

						selectedSeatsReturnB.add("16D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("16D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn16D_B.setBounds(315, 729, 65, 30);
		btn16D_B.setForeground(Color.BLACK);
		btn16D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn16D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn16D_B);

		JToggleButton btn16C_B = new JToggleButton("16C");
		btn16C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn16C_B.isSelected()) {

						selectedSeatsDepartB.add("16C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("16C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn16C_B.isSelected()) {

						selectedSeatsReturnB.add("16C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("16C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn16C_B.setBounds(190, 729, 65, 30);
		btn16C_B.setForeground(Color.BLACK);
		btn16C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn16C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn16C_B);

		JButton btn16B_B = new JButton("16B");
		btn16B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				} else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btn16B_B.setBounds(115, 729, 65, 30);
		btn16B_B.setForeground(Color.BLACK);
		btn16B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn16B_B.setBackground(Color.RED);
		Boeing747SeatingPlan.add(btn16B_B);

		JToggleButton btn16A_B = new JToggleButton("16A");
		btn16A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn16A_B.isSelected()) {

						selectedSeatsDepartB.add("16A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("16A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn16A_B.isSelected()) {

						selectedSeatsReturnB.add("16A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("16A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn16A_B.setBounds(40, 729, 65, 30);
		btn16A_B.setForeground(Color.BLACK);
		btn16A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn16A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn16A_B);

		JToggleButton btn17A_B = new JToggleButton("17A");
		btn17A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn17A_B.isSelected()) {

						selectedSeatsDepartB.add("17A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("17A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn17A_B.isSelected()) {

						selectedSeatsReturnB.add("17A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("17A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn17A_B.setBounds(40, 769, 65, 30);
		btn17A_B.setForeground(Color.BLACK);
		btn17A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn17A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn17A_B);

		JToggleButton btn17B_B = new JToggleButton("17B");
		btn17B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn17B_B.isSelected()) {

						selectedSeatsDepartB.add("17B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("17B");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn17B_B.isSelected()) {

						selectedSeatsReturnB.add("17B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("17B");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn17B_B.setBounds(115, 769, 65, 30);
		btn17B_B.setForeground(Color.BLACK);
		btn17B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn17B_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn17B_B);

		JToggleButton btn17C_B = new JToggleButton("17C");
		btn17C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn17C_B.isSelected()) {

						selectedSeatsDepartB.add("17C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("17C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn17C_B.isSelected()) {

						selectedSeatsReturnB.add("17C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("17C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn17C_B.setBounds(190, 769, 65, 30);
		btn17C_B.setForeground(Color.BLACK);
		btn17C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn17C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn17C_B);

		JToggleButton btn17D_B = new JToggleButton("17D");
		btn17D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn17D_B.isSelected()) {

						selectedSeatsDepartB.add("17D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("17D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn17D_B.isSelected()) {

						selectedSeatsReturnB.add("17D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("17D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn17D_B.setBounds(315, 769, 65, 30);
		btn17D_B.setForeground(Color.BLACK);
		btn17D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn17D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn17D_B);

		JToggleButton btn17E_B = new JToggleButton("17E");
		btn17E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn17E_B.isSelected()) {

						selectedSeatsDepartB.add("17E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("17E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn17E_B.isSelected()) {

						selectedSeatsReturnB.add("17E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("17E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn17E_B.setBounds(390, 769, 65, 30);
		btn17E_B.setForeground(Color.BLACK);
		btn17E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn17E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn17E_B);

		JToggleButton btn17F_B = new JToggleButton("17F");
		btn17F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn17F_B.isSelected()) {

						selectedSeatsDepartB.add("17F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("17F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn17F_B.isSelected()) {

						selectedSeatsReturnB.add("17F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("17F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn17F_B.setBounds(465, 769, 65, 30);
		btn17F_B.setForeground(Color.BLACK);
		btn17F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn17F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn17F_B);

		JToggleButton btn18F_B = new JToggleButton("18F");
		btn18F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn18F_B.isSelected()) {

						selectedSeatsDepartB.add("18F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("18F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn18F_B.isSelected()) {

						selectedSeatsReturnB.add("18F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("18F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn18F_B.setBounds(465, 809, 65, 30);
		btn18F_B.setForeground(Color.BLACK);
		btn18F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn18F_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn18F_B);

		JToggleButton btn18E_B = new JToggleButton("18E");
		btn18E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn18E_B.isSelected()) {

						selectedSeatsDepartB.add("18E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("18E");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn18E_B.isSelected()) {

						selectedSeatsReturnB.add("18E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("18E");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn18E_B.setBounds(390, 809, 65, 30);
		btn18E_B.setForeground(Color.BLACK);
		btn18E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn18E_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn18E_B);

		JToggleButton btn18D_B = new JToggleButton("18D");
		btn18D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn18D_B.isSelected()) {

						selectedSeatsDepartB.add("18D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("18D");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn18D_B.isSelected()) {

						selectedSeatsReturnB.add("18D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("18D");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn18D_B.setBounds(315, 809, 65, 30);
		btn18D_B.setForeground(Color.BLACK);
		btn18D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn18D_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn18D_B);

		JToggleButton btn18C_B = new JToggleButton("18C");
		btn18C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn18C_B.isSelected()) {

						selectedSeatsDepartB.add("18C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("18C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn18C_B.isSelected()) {

						selectedSeatsReturnB.add("18C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("18C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn18C_B.setBounds(190, 809, 65, 30);
		btn18C_B.setForeground(Color.BLACK);
		btn18C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn18C_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn18C_B);

		JButton btn18B_B = new JButton("18B");
		btn18B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);
				}

				else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}
			}

		});
		btn18B_B.setBounds(115, 809, 65, 30);
		btn18B_B.setForeground(Color.BLACK);
		btn18B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn18B_B.setBackground(Color.RED);
		Boeing747SeatingPlan.add(btn18B_B);

		JToggleButton btn18A_B = new JToggleButton("18A");
		btn18A_B.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn18A_B.isSelected()) {

						selectedSeatsDepartB.add("18A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("18A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn18A_B.isSelected()) {

						selectedSeatsReturnB.add("18A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("18A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn18A_B.setBounds(40, 809, 65, 30);
		btn18A_B.setForeground(Color.BLACK);
		btn18A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn18A_B.setBackground(Color.LIGHT_GRAY);
		Boeing747SeatingPlan.add(btn18A_B);

		JToggleButton btn19A_B = new JToggleButton("19A");
		btn19A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn19A_B.isSelected()) {

						selectedSeatsDepartB.add("19A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("19A");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn19A_B.isSelected()) {

						selectedSeatsReturnB.add("19A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("19A");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}

			}
		});
		btn19A_B.setForeground(Color.BLACK);
		btn19A_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn19A_B.setBackground(Color.LIGHT_GRAY);
		btn19A_B.setBounds(40, 850, 65, 30);
		Boeing747SeatingPlan.add(btn19A_B);

		JButton btn19B_B = new JButton("19B");
		btn19B_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				} else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btn19B_B.setForeground(Color.BLACK);
		btn19B_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn19B_B.setBackground(Color.RED);
		btn19B_B.setBounds(115, 850, 65, 30);
		Boeing747SeatingPlan.add(btn19B_B);

		JToggleButton btn19C_B = new JToggleButton("19C");
		btn19C_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn19C_B.isSelected()) {

						selectedSeatsDepartB.add("19C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("19C");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn19C_B.isSelected()) {

						selectedSeatsReturnB.add("19C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("19C");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn19C_B.setForeground(Color.BLACK);
		btn19C_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn19C_B.setBackground(Color.LIGHT_GRAY);
		btn19C_B.setBounds(190, 850, 65, 30);
		Boeing747SeatingPlan.add(btn19C_B);

		JButton btn19D_B = new JButton("19D");
		btn19D_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", 0);

				}

				else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", 0);

				}
			}
		});
		btn19D_B.setForeground(Color.BLACK);
		btn19D_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn19D_B.setBackground(Color.RED);
		btn19D_B.setBounds(315, 850, 65, 30);
		Boeing747SeatingPlan.add(btn19D_B);

		JButton btn19E_B = new JButton("19E");
		btn19E_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", 0);

				}

				else {

					JOptionPane.showMessageDialog(frame, "This seat has been taken",
							"Choose seats that are not coloured red", 0);

				}
			}
		});
		btn19E_B.setForeground(Color.BLACK);
		btn19E_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn19E_B.setBackground(Color.RED);
		btn19E_B.setBounds(390, 850, 65, 30);
		Boeing747SeatingPlan.add(btn19E_B);

		JToggleButton btn19F_B = new JToggleButton("19F");
		btn19F_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loopSeatingPlan == 0) {
					if (btn19F_B.isSelected()) {

						selectedSeatsDepartB.add("19F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsDepartB.remove("19F");

						txtFDepartSeats.setText(selectedSeatsDepartB.toString().replace('[', ' ').replace(']', ' '));
					}

				}

				else {

					if (btn19F_B.isSelected()) {

						selectedSeatsReturnB.add("19F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}

					else {
						selectedSeatsReturnB.remove("19F");

						txtFReturnSeats.setText(selectedSeatsReturnB.toString().replace('[', ' ').replace(']', ' '));
					}
				}
			}
		});
		btn19F_B.setForeground(Color.BLACK);
		btn19F_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn19F_B.setBackground(Color.LIGHT_GRAY);
		btn19F_B.setBounds(465, 850, 65, 30);
		Boeing747SeatingPlan.add(btn19F_B);

		btnContinue_B.setBounds(380, 895, 147, 44);
		btnContinue_B.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/* this executable bellow will only occur when the button Continue is pressed */

				if (loopSeatingPlan == 0) {
					/*
					 * if the user is on the first page then the acitons bellow will be checked and
					 * performed
					 */
					if (selectedSeatsDepartB.size() != ticketAmount_D) {
						JOptionPane.showMessageDialog(frame,
								"seats selected is not the same amount as tickets selected",
								"you must select the same amount of tickets to seats  ", JOptionPane.ERROR_MESSAGE);

						/*
						 * the user will not continue unless the ticket amount is = to the departure
						 * seats selected for boieng747, a error message will appear telling the user
						 * that
						 */
					}

					else if (selectedSeatsDepartB.isEmpty()) {

						JOptionPane.showMessageDialog(frame, "No seats have been selected",
								"you cannot continue Unless at least one seat has been selected",
								JOptionPane.ERROR_MESSAGE);

						/*
						 * if no seats have been selected then the user cannot continue to the next page
						 */
					} else {

						/* if all conditions are true then the executables bellow will be performed */
						loopSeatingPlan += 1;
						/*
						 * adding 1 to loopSeatingPlan to change the executables of other if statements
						 * when going to the next page
						 */
						btnBack_B.setEnabled(true);
						Boeing747SeatingPlan.hide();
						Boeing747SeatingPlan.show();
						lblDepartureFlightSeats_B.hide();
						lblReturnFlightSeats_B.show();
						/* this will display the ticket Amount for returns in a text field */
						TxtFTicketAmount_D.setText(
								ticketAmounts = Integer.toString(ticketAmount_R).replace('[', ' ').replace(']', ' '));

						JOptionPane.showMessageDialog(frame, "you must reselect the seats you want for Return");
						/* this will display a */

					}

				}

				else {
					if (selectedSeatsReturnB.size() != ticketAmount_R) {

						JOptionPane.showMessageDialog(frame,
								"seats selected is not the same amount as tickets selected",
								"you must select the same amount of tickets to seats  ", JOptionPane.ERROR_MESSAGE);
					}

					else if (selectedSeatsReturnB.isEmpty()) {

						JOptionPane.showMessageDialog(frame, "No seats have been selected",
								"you cannot continue Unless a seats has been selected", JOptionPane.ERROR_MESSAGE);

					}

					else {
						Boeing747SeatingPlan.hide();
						lblDepartureFlightSeats_B.hide();
						lblReturnFlightSeats_B.hide();
						plBack.show();

					}

				}

			}
		});
		Boeing747SeatingPlan.setLayout(null);
		btnContinue_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Boeing747SeatingPlan.add(btnContinue_B);
		// }
		// BOEING SEATING PLAN - end

		btnBack_B.setEnabled(false);
		btnBack_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (seatDisplay == 1) {

					loopSeatingPlan -= 1;
					Boeing747SeatingPlan.show();
					btnBack_B.setEnabled(false);
					plBack.hide();

					lblDepartureFlightSeats_B.show();
					lblReturnFlightSeats_B.hide();
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_D).replace('[', ' ').replace(']', ' '));
					JOptionPane.showMessageDialog(frame,
							"to remove the seats you want just repress the seat for departure");

				} else { /* if the seatDisplay isn't = 2 then the actions bellow would occur */

					Boeing747SeatingPlan.show();

					plBack.hide();

					lblDepartureFlightSeats_B.hide();
					lblReturnFlightSeats_B.show();
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_D).replace('[', ' ').replace(']', ' '));
					JOptionPane.showMessageDialog(frame,
							"to remove the seats you want just repress the seat for return");

				}

			}
		});
		btnBack_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack_B.setBounds(200, 895, 155, 48);
		Boeing747SeatingPlan.add(btnBack_B);

		btnBack_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * when the back button for AirbusA318 is pressed it will caused the action
				 * bellow
				 */

				if (seatDisplay == 2) {

					/*
					 * if the seatDisplay is on the Return seats page then the following executables
					 * will be performed bellow
					 */

					loopSeatingPlan -= 1; /* Minus 1 from the integer LoopSeatingPlan */
					AirbusA318SeatingPlan.show();

					/* this will cause the previous */

					plBack.hide();

					lblDepartureFlightSeats_A.show();
					lblReturnFlightSeats_A.hide();
					/*
					 * This executable will display the ticket amounts selected for departure when
					 * going back to the page departure
					 */
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_D).replace('[', ' ').replace(']', ' '));
					JOptionPane.showMessageDialog(frame,
							"to remove the seats you want just repress the seats you have selected for departure");

				} else { /* if the seatDisplay isn't = 2 then the actions bellow would occur */
					AirbusA318SeatingPlan.hide();
					Boeing747SeatingPlan.show();
					plBack.hide();

					lblDepartureFlightSeats_A.hide();
					lblReturnFlightSeats_A.show();
					/* Hide and show the DepartureFlight label and ReturnFlight label */

					/*
					 * this executable will display the ticket amounts selected for return flight,
					 * when going back to the page return
					 */
					TxtFTicketAmount_D.setText(
							ticketAmounts = Integer.toString(ticketAmount_R).replace('[', ' ').replace(']', ' '));
					JOptionPane.showMessageDialog(frame,
							"to remove the seats you want just repress the seats selected for return");

				}

			}
		});
		btnBack_A.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack_A.setBounds(230, 876, 155, 48);
		AirbusA318SeatingPlan.add(btnBack_A);

		// button to go back a page
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * This button is located on the last page which allows the user to return to
				 * return page and departures page
				 */

				if (seatDisplay == 2) {
					/* if the seatDisplay = AirbusA318 then the following */

					AirbusA318SeatingPlan.show(); /* Show AirbusA318 and hide boeing747 seating plan */
					Boeing747SeatingPlan.hide();
					plBack.hide();

					lblDepartureFlightSeats_A.hide();
					lblReturnFlightSeats_A.show();
					JOptionPane.showMessageDialog(frame, "You must reselect the seats you want for return");

				} else { /*
							 * if the seatDisplay isn't = 2 then the actions bellow would occur for
							 * boeing747
							 */
					AirbusA318SeatingPlan.hide(); /* Hide AirbusA318 and show boeing747 seating plan */
					Boeing747SeatingPlan.show();
					plBack.hide();

					lblDepartureFlightSeats_B.hide();
					lblReturnFlightSeats_B.show();
					JOptionPane.showMessageDialog(frame, "You must reselect the seats you want to remove for return");
					/*
					 * a Message Dialog box will appear when going back a page to inform the user to
					 * reselect the seats to remove them
					 */

				}

			}
		});
		btnBack.setBounds(100, 350, 340, 202);
		plBack.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(631, 724, 216, 149);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(22, 19, 177, 115);
		panel.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * When the button submit is pressed the following actions bellow will be
				 * performed
				 */

				int result = JOptionPane.showConfirmDialog(frame, "Sure? You want to continue?", "Swing Tester",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				/* This defines the Yes and No options in the confirm dialog box */

				if (seatDisplay == 2) {
					/*
					 * if the seat displayed is Airbusa318 then the folLowing conditions would be
					 * utilised with the following executables
					 */
					if (selectedSeatsDepartA.isEmpty()) {

						JOptionPane.showMessageDialog(null, "A seat Hasn't been chosen",
								"You must pick a seat before continuing ", JOptionPane.ERROR_MESSAGE);
						/*
						 * This will display a ERROrMessAGE if no seats have been picked for departure
						 */

					}

					else if (selectedSeatsReturnA.isEmpty()) {

						JOptionPane.showMessageDialog(null, "A seat Hasn't been chosen",
								"You must pick a seat before continuing ", JOptionPane.ERROR_MESSAGE);
						/* This will display an Error message if no seats have been picked for return */

					}

					else {

						/*
						 * if all conditions have been met from above then the bellow would be the final
						 * executable, this would display the ConfirmDialog when all conditions above
						 * have been met
						 */

						if (result == JOptionPane.YES_OPTION) {

							/*
							 * if the user picks the option yes then it will close the program, add the
							 * array lists that contain the selected seats into a new array list, for the
							 * previous to be cleared automatically
							 */
							seatsDepart = selectedSeatsDepartA;
							seatsReturn = selectedSeatsReturnA;
							frame.dispose();
							selectedSeatsDepartA.clear();
							selectedSeatsReturnA.clear();

						}

						/* if the user picks no then nothing would happen */

						else if (result == JOptionPane.NO_OPTION) {

						} else {

						}
					}

				} else {

					if (selectedSeatsDepartB.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A seat Hasn't been chosen",
								"You must pick a seat before continuing ", JOptionPane.ERROR_MESSAGE);
					}

					else if (selectedSeatsReturnB.isEmpty()) {
						JOptionPane.showMessageDialog(null, "A seat Hasn't been chosen",
								"You must pick a seat before continuing ", JOptionPane.ERROR_MESSAGE);
					}

					else {

						if (result == JOptionPane.YES_OPTION) {
							seatsDepart = selectedSeatsDepartB;
							seatsReturn = selectedSeatsReturnB;
							frame.dispose();
							selectedSeatsDepartB.clear();
							selectedSeatsReturnB.clear();

						} else if (result == JOptionPane.NO_OPTION) {

						} else {

						}

					}
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// seatDisplay method

		/*
		 * this if statement displays the seating plans and label for both departure and
		 * returns depending on the the seatDisplay value, as a default screening.
		 */

		if (seatDisplay == 2) {
			/*
			 * This hides pages that shoudln't be seen or be utilised by the user based on
			 * the conditions
			 */
			AirbusA318SeatingPlan.show();
			Boeing747SeatingPlan.hide();
			plBack.hide();

			lblDepartureFlightSeats_A.show();
			lblReturnFlightSeats_A.hide();

		} else { /* if the seatDisplay isn't = 2 then the actions bellow would occur */
			AirbusA318SeatingPlan.hide();
			Boeing747SeatingPlan.show();
			plBack.hide();

			lblDepartureFlightSeats_B.show();
			lblReturnFlightSeats_B.hide();

		}
	}
}
