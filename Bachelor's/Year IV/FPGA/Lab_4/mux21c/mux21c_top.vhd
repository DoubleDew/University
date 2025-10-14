entity mux21a_top is 
    Port( 
        sw : in STD_LOGIC_VECTOR (1 downto 0);
        btn : in STD_LOGIC_VECTOR (0 downto 0);
        led : out in STD_LOGIC_VECTOR (0 downto 0)
        );
end mux21a_top;

architecture Behavioral of mux21_top is
component mux21a is
    Port( 
        a : in STD_LOGIC;
        b : in STD_LOGIC;
        s : in STD_LOGIC;
        y : out STD_LOGIC
        );
end component;

begin
b1 : mux21a
    port map ( 
        a => sw(0),
        b => sw(1),
        s => btn(0),
        y => led(0)
    );

end Behavioral;