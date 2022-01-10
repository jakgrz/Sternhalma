public class Map {
    private Field[][] fields;
    private int players;

    public Map(int players) {
        fields = new Field[17][25];
        this.players = players;

        for (int i = 0; i < 17; ++i) {
            for (int j = 0; j < 25; ++j) {
                if (i == 0) {
                    if (j == 12) {
                        if (players == 2 || players == 3 || players == 4 || players == 6) {
                            setField(i, j, 1,true);
                        } else {
                            setField(i, j, 0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 1) {
                    if (j == 11 || j == 13) {
                        if (players == 2 || players == 3 || players == 4 || players == 6) {
                            setField(i, j, 1,true);
                        } else {
                            setField(i, j, 0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 2) {
                    if (j == 10 || j == 12 || j == 14) {
                        if (players == 2 || players == 3 || players == 4 || players == 6) {
                            setField(i, j, 1,true);
                        } else {
                            setField(i, j, 0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 3) {
                    if (j == 9 || j == 11 || j == 13 || j == 15) {
                        if (players == 2 || players == 3 || players == 4 || players == 6) {
                            setField(i, j, 1,true);
                        } else {
                            setField(i, j, 0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 4) {
                    if (j % 2 == 0) {
                        if (j < 7) {
                            if (players == 6) {
                                setField(i, j, 6,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 17) {
                            if (players == 4 || players == 6) {
                                setField(i, j, 2,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 5) {
                    if (j % 2 == 1) {
                        if (j < 7) {
                            if (players == 6) {
                                setField(i, j, 6,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 17) {
                            if (players == 4 || players == 6) {
                                setField(i, j, 2,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 6) {
                    if (j % 2 == 0 && j != 0 && j != 24) {
                        if (j < 5) {
                            if (players == 6) {
                                setField(i, j, 6,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 19) {
                            if (players == 4 || players == 6) {
                                setField(i, j, 2,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 7) {
                    if (j % 2 == 1 && j != 1 && j != 23) {
                        if (j < 5) {
                            if (players == 6) {
                                setField(i, j, 6,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 19) {
                            if (players == 4 || players == 6) {
                                setField(i, j, 2,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 8) {
                    if (j % 2 == 0 && j != 0 && j != 2 && j != 22 && j != 24) {
                        setField(i, j,0,true);
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 9) {
                    if (j % 2 == 1 && j != 1 && j != 23) {
                        if (j < 5) {
                            if (players == 3) {
                                setField(i, j, 3,true);
                            } else if (players == 4) {
                                setField(i, j, 4,true);
                            } else if (players == 6) {
                                setField(i, j, 5,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 19) {
                            if (players == 3) {
                                setField(i, j, 2,true);
                            } else if (players == 6) {
                                setField(i, j, 3,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 10) {
                    if (j % 2 == 0 && j != 0 && j != 24) {
                        if (j < 5) {
                            if (players == 3) {
                                setField(i, j, 3,true);
                            } else if (players == 4) {
                                setField(i, j, 4,true);
                            } else if (players == 6) {
                                setField(i, j, 5,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 19) {
                            if (players == 3) {
                                setField(i, j, 2,true);
                            } else if (players == 6) {
                                setField(i, j, 3,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 11) {
                    if (j % 2 == 1) {
                        if (j < 7) {
                            if (players == 3) {
                                setField(i, j, 3,true);
                            } else if (players == 4) {
                                setField(i, j, 4,true);
                            } else if (players == 6) {
                                setField(i, j, 5,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 17) {
                            if (players == 3) {
                                setField(i, j, 2,true);
                            } else if (players == 6) {
                                setField(i, j, 3,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 12) {
                    if (j % 2 == 0) {
                        if (j < 7) {
                            if (players == 3) {
                                setField(i, j, 3,true);
                            } else if (players == 4) {
                                setField(i, j, 4,true);
                            } else if (players == 6) {
                                setField(i, j, 5,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else if (j > 17) {
                            if (players == 3) {
                                setField(i, j, 2,true);
                            } else if (players == 6) {
                                setField(i, j, 3,true);
                            } else {
                                setField(i, j, 0,true);
                            }
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 13) {
                    if (j == 9 || j == 11 || j == 13 || j == 15) {
                        if (players == 2) {
                            setField(i, j, 2,true);
                        } else if (players == 4) {
                            setField(i, j, 3,true);
                        } else if (players == 6) {
                            setField(i, j, 4,true);
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 14) {
                    if (j == 10 || j == 12 || j == 14) {
                        if (players == 2) {
                            setField(i, j, 2,true);
                        } else if (players == 4) {
                            setField(i, j, 3,true);
                        } else if (players == 6) {
                            setField(i, j, 4,true);
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 15) {
                    if (j == 11 || j == 13) {
                        if (players == 2) {
                            setField(i, j, 2,true);
                        } else if (players == 4) {
                            setField(i, j, 3,true);
                        } else if (players == 6) {
                            setField(i, j,4,true);
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                } else if (i == 16) {
                    if (j == 12) {
                        if (players == 2) {
                            setField(i, j, 2,true);
                        } else if (players == 4) {
                            setField(i, j, 3,true);
                        } else if (players == 6) {
                            setField(i, j, 4,true);
                        } else {
                            setField(i, j,0,true);
                        }
                    } else {
                        setField(i, j, 0,false);
                    }
                }
            }
        }
    }

    private void setField(int x, int y, int color1, boolean isEnabled) {
        this.fields[x][y] = new Field(color1, isEnabled,50 + 17.5 * y, 50 + 30 * x);
    }

    public Field getField(int x, int y) {
        return this.fields[x][y];
    }
}
