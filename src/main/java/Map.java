/**
 * This class is a map of a game board and contains field objects
 */
public class Map {

    private Field[][] fields;
    private int players;

    /**
     * Constructor that creates the map by filling it with a set of fields
     * @param players is number of players
     */
    public Map(int players) {
        fields = new Field[17][25];
        this.players = players;

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                if (i == 0) {
                    if (j == 12) {
                        if (players == 2) {
                            setField(i, j, 1,2,true);
                        } else if (players == 3) {
                            setField(i, j, 1,0,true);
                        } else if (players == 4) {
                            setField(i, j, 1,3,true);
                        } else if (players == 6) {
                            setField(i, j, 1,4,true);
                        } else {
                            setField(i, j, 0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 1) {
                    if (j == 11 || j == 13) {
                        if (players == 2) {
                            setField(i, j, 1,2,true);
                        } else if (players == 3) {
                            setField(i, j, 1,0,true);
                        } else if (players == 4) {
                            setField(i, j, 1,3,true);
                        } else if (players == 6) {
                            setField(i, j, 1,4,true);
                        } else {
                            setField(i, j, 0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 2) {
                    if (j == 10 || j == 12 || j == 14) {
                        if (players == 2) {
                            setField(i, j, 1,2,true);
                        } else if (players == 3) {
                            setField(i, j, 1,0,true);
                        } else if (players == 4) {
                            setField(i, j, 1,3,true);
                        } else if (players == 6) {
                            setField(i, j, 1,4,true);
                        } else {
                            setField(i, j, 0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 3) {
                    if (j == 9 || j == 11 || j == 13 || j == 15) {
                        if (players == 2) {
                            setField(i, j, 1,2,true);
                        } else if (players == 3) {
                            setField(i, j, 1,0,true);
                        } else if (players == 4) {
                            setField(i, j, 1,3,true);
                        } else if (players == 6) {
                            setField(i, j, 1,4,true);
                        } else {
                            setField(i, j, 0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 4) {
                    if (j % 2 == 0) {
                        if (j < 7) {
                            if (players == 3) {
                                setField(i, j, 0,2,true);
                            } else if (players == 6) {
                                setField(i, j, 6,3,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 17) {
                            if (players == 3) {
                                setField(i, j, 0,3,true);
                            } else if (players == 4) {
                                setField(i, j, 2,4,true);
                            } else if (players == 6) {
                                setField(i, j, 2,5,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 5) {
                    if (j % 2 == 1) {
                        if (j < 7) {
                            if (players == 3) {
                                setField(i, j, 0,2,true);
                            } else if (players == 6) {
                                setField(i, j, 6,3,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 17) {
                            if (players == 3) {
                                setField(i, j, 0,3,true);
                            } else if (players == 4) {
                                setField(i, j, 2,4,true);
                            } else if (players == 6) {
                                setField(i, j, 2,5,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 6) {
                    if (j % 2 == 0 && j != 0 && j != 24) {
                        if (j < 5) {
                            if (players == 3) {
                                setField(i, j, 0,2,true);
                            } else if (players == 6) {
                                setField(i, j, 6,3,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 19) {
                            if (players == 3) {
                                setField(i, j, 0,3,true);
                            } else if (players == 4) {
                                setField(i, j, 2,4,true);
                            } else if (players == 6) {
                                setField(i, j, 2,5,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 7) {
                    if (j % 2 == 1 && j != 1 && j != 23) {
                        if (j < 5) {
                            if (players == 3) {
                                setField(i, j, 0,2,true);
                            } else if (players == 6) {
                                setField(i, j, 6,3,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 19) {
                            if (players == 3) {
                                setField(i, j, 0,3,true);
                            } else if (players == 4) {
                                setField(i, j, 2,4,true);
                            } else if (players == 6) {
                                setField(i, j, 2,5,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 8) {
                    if (j % 2 == 0 && j != 0 && j != 2 && j != 22 && j != 24) {
                        setField(i, j,0,0,true);
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 9) {
                    if (j % 2 == 1 && j != 1 && j != 23) {
                        if (j < 5) {
                            if (players == 3) {
                                setField(i, j, 3,0,true);
                            } else if (players == 4) {
                                setField(i, j, 4,2,true);
                            } else if (players == 6) {
                                setField(i, j, 5,2,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 19) {
                            if (players == 3) {
                                setField(i, j, 2,0,true);
                            } else if (players == 6) {
                                setField(i, j, 3,6,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 10) {
                    if (j % 2 == 0 && j != 0 && j != 24) {
                        if (j < 5) {
                            if (players == 3) {
                                setField(i, j, 3,0,true);
                            } else if (players == 4) {
                                setField(i, j, 4,2,true);
                            } else if (players == 6) {
                                setField(i, j, 5,2,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 19) {
                            if (players == 3) {
                                setField(i, j, 2,0,true);
                            } else if (players == 6) {
                                setField(i, j, 3,6,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 11) {
                    if (j % 2 == 1) {
                        if (j < 7) {
                            if (players == 3) {
                                setField(i, j, 3,0,true);
                            } else if (players == 4) {
                                setField(i, j, 4,2,true);
                            } else if (players == 6) {
                                setField(i, j, 5,2,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 17) {
                            if (players == 3) {
                                setField(i, j, 2,0,true);
                            } else if (players == 6) {
                                setField(i, j, 3,6,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 12) {
                    if (j % 2 == 0) {
                        if (j < 7) {
                            if (players == 3) {
                                setField(i, j, 3,0,true);
                            } else if (players == 4) {
                                setField(i, j, 4,2,true);
                            } else if (players == 6) {
                                setField(i, j, 5,2,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else if (j > 17) {
                            if (players == 3) {
                                setField(i, j, 2,0,true);
                            } else if (players == 6) {
                                setField(i, j, 3,6,true);
                            } else {
                                setField(i, j, 0,0,true);
                            }
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 13) {
                    if (j == 9 || j == 11 || j == 13 || j == 15) {
                        if (players == 2) {
                            setField(i, j, 2,1,true);
                        } else if (players == 3) {
                            setField(i, j, 0,1,true);
                        } else if (players == 4) {
                            setField(i, j, 3,1,true);
                        } else if (players == 6) {
                            setField(i, j, 4,1,true);
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 14) {
                    if (j == 10 || j == 12 || j == 14) {
                        if (players == 2) {
                            setField(i, j, 2,1,true);
                        } else if (players == 3) {
                            setField(i, j, 0,1,true);
                        } else if (players == 4) {
                            setField(i, j, 3,1,true);
                        } else if (players == 6) {
                            setField(i, j, 4,1,true);
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 15) {
                    if (j == 11 || j == 13) {
                        if (players == 2) {
                            setField(i, j, 2,1,true);
                        } else if (players == 3) {
                            setField(i, j, 0,1,true);
                        } else if (players == 4) {
                            setField(i, j, 3,1,true);
                        } else if (players == 6) {
                            setField(i, j, 4,1,true);
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                } else if (i == 16) {
                    if (j == 12) {
                        if (players == 2) {
                            setField(i, j, 2,1,true);
                        } else if (players == 3) {
                            setField(i, j, 0,1,true);
                        } else if (players == 4) {
                            setField(i, j, 3,1,true);
                        } else if (players == 6) {
                            setField(i, j, 4,1,true);
                        } else {
                            setField(i, j,0,0,true);
                        }
                    } else {
                        setField(i, j, 0,0,false);
                    }
                }
            }
        }
    }

    /**
     * This method creates or modifies a field at certain coordinates
     * @param x is first coordinate of the field on the board
     * @param y is second coordinate of the field on the board
     * @param color1 is the current color id of the field
     * @param color2 is the destination color id of the field
     * @param isEnabled indicates whether the field is active
     */
    private void setField(int x, int y, int color1, int color2, boolean isEnabled) {
        this.fields[x][y] = new Field(color1, color2, isEnabled,50 + 17.5 * y, 50 + 30 * x);
    }

    /**
     * This method returns a field at certain coordinates
     * @param x is first coordinate of the field on the board
     * @param y is second coordinate of the field on the board
     * @return field at certain coordinates
     */
    public Field getField(int x, int y) {
        return this.fields[x][y];
    }
}
