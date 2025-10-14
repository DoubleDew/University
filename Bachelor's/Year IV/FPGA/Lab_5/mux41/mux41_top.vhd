entity mux41_top is
    Port( 
        sw : in STD_LOGIC_VECTOR (3 downto 0);
        btn : in STD_LOGIC_VECTOR (2 downto 0);
        led : out STD_LOGIC
        );
end mux41_top;

architecture Behavioral of mux41_top is
component mux41 is
    Port( 
        c : in STD_LOGIC_VECTOR (3 downto 0);
        s : in STD_LOGIC_VECTOR (1 downto 0);
        z : out STD_LOGIC
        );
end component;

begin
c1 : mux41
    port map ( 
        -- c => sw,
        c(0) => sw(0),
        c(1) => sw(1),
        c(2) => sw(2),
        c(3) => sw(3),
        -- s => btn(1 downto 0),
        s(0) => btn(0),
        s(1) => btn(1),
        -- z => led
        z => led(0)
    );

end Behavioral;