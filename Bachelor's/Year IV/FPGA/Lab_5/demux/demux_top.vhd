entity demux_top is
    Port( 
        sw : in STD_LOGIC_VECTOR (0 downto 0);
        btn : in STD_LOGIC_VECTOR (1 downto 0);
        led : out STD_LOGIC_VECTOR (3 downto 0)
        );
end demux_top;

architecture Behavioral of demux_top is
component demux is 
    Port( 
        a : in STD_LOGIC_VECTOR (0 downto 0);
        s : in STD_LOGIC_VECTOR (1 downto 0);
        z : out STD_LOGIC_VECTOR (3 downto 0)
        );
end component;

begin
    b1 : demux
        port map ( 
            a => sw,
            s => btn,
            z => led
        );
end Behavioral;