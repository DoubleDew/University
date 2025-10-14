entity sw_led_top is 
	port(
		sw : in STD_LOGIC_VECTOR (7 downto 0) ;
		led : out STD_LOGIC_VECTOR (7 downto 0)
	)
end sw_led_top;

architecture Behavioral of sw_led_top is 
	component sw_led is 
	port(
			A: in STD_LOGIC_VECTOR (7 downto 0) ; 
		   	Y : out STD_LOGIC_VECTOR (7 downto 0)
		);
	end component;

	constant period : time := 10 ns;
	
	signal A: std_logic_vector (7 downto 0) ; 
		signal Y : std_logic_vector (7 downto 0) ; 
		
begin 
   c1: sw_led
	port map(
	 A => A, 
	 Y => Y
	 );
	 process 
	 begin 
	 A <= "00110011";
	 wait for period;
	 A <= "01110011";
	 wait for period;
	 A <= "00111011";
	 wait for period;
	 A <= "01000011";
	 wait for period;
	 end process;
	 
end Behavioral;